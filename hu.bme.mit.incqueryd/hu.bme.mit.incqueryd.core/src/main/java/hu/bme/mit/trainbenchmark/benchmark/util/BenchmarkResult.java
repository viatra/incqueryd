package hu.bme.mit.trainbenchmark.benchmark.util;

import hu.bme.mit.trainbenchmark.benchmark.config.IncQueryDBenchmarkConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class BenchmarkResult {
	String tool;
	String query;
	String fileName = "undef";
	String scenario = "";
	int series;
	StampedValue<Integer> size = new StampedValue<Integer>(-1);
	IncQueryDBenchmarkConfig benchmarkConfig;

	StampedValue<Long> readTime = new StampedValue<Long>(-1L);
	ArrayList<StampedValue<Long>> checkTime = new ArrayList<StampedValue<Long>>();
	Long checkTimeSum = new Long(-1L);
	ArrayList<StampedValue<Long>> checkInvalid = new ArrayList<StampedValue<Long>>();
	ArrayList<StampedValue<Long>> modificationTime = new ArrayList<StampedValue<Long>>();
	Long modificationTimeSum = new Long(-1L);
	ArrayList<StampedValue<Long>> editTime = new ArrayList<StampedValue<Long>>();
	Long editTimeSum = new Long(-1L);
	ArrayList<StampedValue<Long>> nElemToModify = new ArrayList<StampedValue<Long>>();
	Long nElemToModifySum = new Long(-1L);
	ArrayList<StampedValue<Long>> memoryBytes = new ArrayList<StampedValue<Long>>();
	StampedValue<Long> memoryBytes2 = new StampedValue<Long>(-1L);
	StampedValue<Long> memoryBytes3 = new StampedValue<Long>(-1L);
	StampedValue<Long> time2 = new StampedValue<Long>(-1L);
	StampedValue<Long> time3 = new StampedValue<Long>(-1L);
	StampedValue<Long> time4 = new StampedValue<Long>(-1L);

	Random random;
	StampedValue<Long> index = new StampedValue<Long>(1L);

	public BenchmarkResult(final String tool, final String query, final int size, final int series) {
		this.tool = tool;
		this.query = query;
		this.size = new StampedValue<Integer>(size);
		this.series = series;
	}

	@Override
	public String toString() {
		// String[] splitId = id.split("_");
		/*
		 * for(int i = 0; i < checkTime.size(); i++) { System.out.println(checkTime.get(i).getTimeStamp() + " " +
		 * checkTime.get(i).getValue() + " " + checkInvalid.get(i).getValue()); }
		 */
		String result = series + " " + tool + " " + query + " " + "XForm" + " " + fileName
				+ " " + size + " " + nElemToModifySum + " " + readTime + " "
				+ (checkTime.size() > 0 ? checkTime.get(0) : "-1") + " " + modificationTimeSum + " "
				+ (checkTime.size() > 1 ? checkTimeSum - checkTime.get(0).getValue() : "-1") + " " + editTimeSum + " "
				+ (checkInvalid.size() > 0 ? checkInvalid.get(0) : "-1") + " "
				+ (checkInvalid.size() > 1 ? checkInvalid.get(checkInvalid.size() - 1) : "-1") + " ";
//				+ memoryBytes.get(memoryBytes.size() - 1).getValue() / 1024;

		/*
		 * // method 1: last 50% avg double errorPercent50 = 25.0; long avgCheck = 0; long avgModify = 0; for(int i =
		 * checkTime.size()/2; i < checkTime.size(); i++) { avgCheck += checkTime.get(i).getValue(); avgModify +=
		 * modificationTime.get(i-1).getValue(); } avgCheck /= checkTime.size() - checkTime.size()/2; avgModify /=
		 * checkTime.size() - checkTime.size()/2; result += avgCheck + " "; result += avgModify + " "; int firstBad50;
		 * for(firstBad50 = checkTime.size()-1; firstBad50 > 1; firstBad50--) { if
		 * ((100.0*Math.abs(checkTime.get(firstBad50).getValue()-avgCheck)/avgCheck > errorPercent50) ||
		 * (100.0*Math.abs(modificationTime.get(firstBad50-1).getValue()-avgModify)/avgModify > errorPercent50)) {
		 * break; } } result += firstBad50 + " ";
		 * 
		 * // method 2: sliding window double errorPercentSW = 25.0; int windowSize = 5; int firstGoodSW; long
		 * minCheckValue = Long.getMAX_VALUE; long minModifyValue = Long.getMAX_VALUE; long maxCheckValue =
		 * Long.MIN_VALUE; long maxModifyValue = Long.MIN_VALUE; for(firstGoodSW = windowSize; firstGoodSW <
		 * checkTime.size(); firstGoodSW++) { for(int j = 0; j < windowSize; j++) { if (minCheckValue >
		 * checkTime.get(firstGoodSW-j).getValue()) { minCheckValue = checkTime.get(firstGoodSW-j).getValue(); } if
		 * (minModifyValue > modificationTime.get(firstGoodSW-j-1).getValue()) { minModifyValue =
		 * modificationTime.get(firstGoodSW-j-1).getValue(); } if (maxCheckValue <
		 * checkTime.get(firstGoodSW-j).getValue()) { maxCheckValue = checkTime.get(firstGoodSW-j).getValue(); } if
		 * (maxModifyValue < modificationTime.get(firstGoodSW-j-1).getValue()) { maxModifyValue =
		 * modificationTime.get(firstGoodSW-j-1).getValue(); } } if ((100.0*(maxCheckValue-minCheckValue)/minCheckValue
		 * < errorPercentSW) && (100.0*(maxModifyValue-minModifyValue)/minModifyValue < errorPercentSW)) { break; } }
		 * result += minCheckValue + " "; result += minModifyValue + " "; result += firstGoodSW + " ";
		 * 
		 * 
		 * // method 3 //System.out.println("Method3"); ArrayList<StampedValue<Long>> checkTimeSorted = new
		 * ArrayList<StampedValue<Long>>(checkTime); Collections.sort(checkTimeSorted, new
		 * StampedValueLongComparable()); Long medianCheck = checkTimeSorted.get(checkTimeSorted.size()/2).getValue();
		 * double lowPercentil = 5; double highPercentil = 95; Long lowBoundary = checkTimeSorted.get((new
		 * Long(Math.round(1.0*checkTimeSorted.size()/100*lowPercentil)).intValue())).getValue(); Long index = new
		 * Long(Math.round(round(1.0*checkTimeSorted.size()/100*highPercentil, 0, BigDecimal.ROUND_DOWN))); Long
		 * highBoundary = checkTimeSorted.get(index.intValue()).getValue(); int firstBadIdx = -1; boolean foundBad =
		 * false; //System.out.println(lowPercentil + " " + lowBoundary); //System.out.println(highPercentil + " " +
		 * highBoundary); for(firstBadIdx = checkTime.size()-1; firstBadIdx >= 0; firstBadIdx--) { if
		 * ((checkTime.get(firstBadIdx).getValue() > highBoundary) || (checkTime.get(firstBadIdx).getValue() <
		 * lowBoundary)) { //System.out.println(firstBadIdx + " " + checkTime.get(firstBadIdx).getValue()); foundBad =
		 * true; break; } } result += medianCheck + " "; if (foundBad) result += firstBadIdx + " "; else result +=
		 * "-1 ";
		 * 
		 * // method 4 (depends on method 3, median) double errorPercent4=20.0; boolean foundBad4 = false; int
		 * firstBadIdx4 = -1; for(firstBadIdx4 = checkTime.size()-1; firstBadIdx4 >= 0; firstBadIdx4--) { if
		 * (100.0*Math.abs(checkTime.get(firstBadIdx4).getValue()-medianCheck)/medianCheck > errorPercent4) { foundBad4
		 * = true; break; } } if (foundBad4) result += firstBadIdx4 + " "; else result += "-1 ";
		 */

		result += "- - - - - - - - - ";

		result += "! ";
		// Print debug info
		for (int i = 0; i < checkTime.size(); i++) {
			result += checkTime.get(i).getValue() + " ";
		}

		result += "! ";
		for (int i = 0; i < editTime.size(); i++) {
			result += editTime.get(i).getValue() + " ";
		}

		result += "! ";
		for (int i = 0; i < checkInvalid.size(); i++) {
			result += checkInvalid.get(i).getValue() + " ";
		}
		result += "! ";

		/*
		 * // remember the extra info you set, they will be printed if (memoryBytes2.getValue() != -1) result = result +
		 * " " + memoryBytes2.getValue() / 1024; if (memoryBytes3.getValue() != -1) result = result + " " +
		 * memoryBytes3.getValue() / 1024; if (time2.getValue() != -1) result = result + " " + time2; if
		 * (time3.getValue() != -1) result = result + " " + time3; if (time4.getValue() != -1) result = result + " " +
		 * time4;
		 */
		return result;
	}

	public static double round(final double unrounded, final int precision, final int roundingMode) {
		final BigDecimal bd = new BigDecimal(unrounded);
		final BigDecimal rounded = bd.setScale(precision, roundingMode);
		return rounded.doubleValue();
	}

	// filename
	public String getFileName() {
		return fileName;
	}

	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	// scenario
	public String getScenario() {
		return scenario;
	}

	public void setScenario(final String scenario) {
		this.scenario = scenario;
	}

	// size
	public StampedValue<Integer> getSize() {
		return size;
	}

	public void setSize(final int size) {
		this.size.setValue(size);
	}

	// read time
	public StampedValue<Long> getReadTime() {
		return readTime;
	}

	public void setReadTime() {
		setReadTime(System.nanoTime() - startTime);
	}

	public void setReadTime(final long readTime) {
		this.readTime.setValue(readTime);
	}

	// check time
	public ArrayList<StampedValue<Long>> getCheckTimes() {
		return checkTime;
	}

	public void addCheckTime() {
		addCheckTime(System.nanoTime() - startTime);
		// System.out.println("CHECK: " + (checkTime.size()-1) + " " + checkTime.get(checkTime.size()-1));
	}

	public void addCheckTime(final long time) {
		if (checkTimeSum == -1L) {
			checkTimeSum = 0L;
		}
		checkTimeSum += time;
		this.checkTime.add(new StampedValue<Long>(time));
	}

	// invalid
	public ArrayList<StampedValue<Long>> getInvalids() {
		return checkInvalid;
	}

	public void addInvalid() {
		addInvalid(System.nanoTime() - startTime);
	}

	public void addInvalid(final long invalids) {
		this.checkInvalid.add(new StampedValue<Long>(invalids));
	}

	// modification time
	public ArrayList<StampedValue<Long>> getModificationTimes(final int index) {
		return modificationTime;
	}

	public void addModificationTime() {
		addModificationTime(System.nanoTime() - startTime);
	}

	public void addModificationTime(final long modificationTime) {
		if (modificationTimeSum == -1L) {
			modificationTimeSum = 0L;
		}
		modificationTimeSum += modificationTime;
		this.modificationTime.add(new StampedValue<Long>(modificationTime));
	}

	// edit time
	public ArrayList<StampedValue<Long>> getEditTimes() {
		return editTime;
	}

	public void addEditTime() {
		addEditTime(System.nanoTime() - startTime);
	}

	public void addEditTime(final long editTime) {
		if (editTimeSum == -1L) {
			editTimeSum = 0L;
		}
		editTimeSum += editTime;
		this.editTime.add(new StampedValue<Long>(editTime));
	}

	// memory
	public ArrayList<StampedValue<Long>> getMemoryBytes() {
		return memoryBytes;
	}

	public void addMemoryBytes(final long memoryBytes) {
		this.memoryBytes.add(new StampedValue<Long>(memoryBytes));
	}

	// nElemToModify
	public ArrayList<StampedValue<Long>> getModifyParams() {
		return nElemToModify;
	}

	public void addModifyParams(final long nElemToModify) {
		if (nElemToModifySum == -1L) {
			nElemToModifySum = 0L;
		}
		nElemToModifySum += nElemToModify;
		this.nElemToModify.add(new StampedValue<Long>(nElemToModify));
	}

	public long getModifyParamsSum() {
		return nElemToModifySum;
	}

	// memory2
	public StampedValue<Long> getMemoryBytes2() {
		return memoryBytes2;
	}

	public void setMemoryBytes2(final long memoryBytes2) {
		this.memoryBytes2.setValue(memoryBytes2);
	}

	// memory3
	public StampedValue<Long> getMemoryBytes3() {
		return memoryBytes3;
	}

	public void setMemoryBytes3(final long memoryBytes3) {
		this.memoryBytes3.setValue(memoryBytes3);
	}

	// time2
	public StampedValue<Long> getTime2() {
		return time2;
	}

	public void setTime2() {
		setTime2(System.nanoTime() - startTime);
	}

	public void setTime2(final long time2) {
		this.time2.setValue(time2);
	}

	// time3
	public StampedValue<Long> getTime3() {
		return time3;
	}

	public void setTime3() {
		setTime3(System.nanoTime() - startTime);
	}

	public void setTime3(final long time3) {
		this.time3.setValue(time3);
	}

	// time4
	public StampedValue<Long> getTime4() {
		return time4;
	}

	public void setTime4() {
		setTime4(System.nanoTime() - startTime);
	}

	public void setTime4(final long time4) {
		this.time4.setValue(time4);
	}

	// index
	public StampedValue<Long> getIndex() {
		return index;
	}

	public void setIndex(final long index) {
		this.index.setValue(index);
	}

	// stopper part
	long startTime;

	public void startStopper() {
		startTime = System.nanoTime();
	}

	public void setRandom(final Random random) {
		this.random = random;
	}

	public IncQueryDBenchmarkConfig getBenchmarkConfig() {
		return benchmarkConfig;
	}

	public void setBenchmarkConfig(final IncQueryDBenchmarkConfig benchmarkConfig) {
		this.benchmarkConfig = benchmarkConfig;
	}

	public String getQuery() {
		return query;
	}
}
