package hu.bme.mit.train.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public enum BenchmarkResult {
	INSTANCE;
	
	private BenchmarkResult() {
		this.random = new UniqRandom(ModificationConstants.RANDOM);
	}
	
	String id;
	String fileName = "undef";
	String scenario = "";
	StampedValue<Integer> size = new StampedValue<Integer>(-1);
	
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
	
	public String toString() {
		String[] splitId = id.split("_");
		/*for(int i = 0; i < checkTime.size(); i++) {
			System.out.println(checkTime.get(i).getTimeStamp() + " " + checkTime.get(i).getValue() + " " + checkInvalid.get(i).getValue());
		}*/
        String result =
        		splitId[0] + " " +
        		splitId[1] + " " +
        		scenario + " " + 
                fileName + " " +
                size + " " +
                nElemToModifySum + " " +
                readTime + " " +
                (checkTime.size() > 0 ? checkTime.get(0) : "-1") + " " +
                modificationTimeSum + " " +
                (checkTime.size() > 1 ? checkTimeSum - checkTime.get(0).getValue() : "-1") + " " +
                editTimeSum + " " +
                (checkInvalid.size() > 0 ? checkInvalid.get(0) : "-1") + " " + 
                (checkInvalid.size() > 1 ? checkInvalid.get(checkInvalid.size()-1) : "-1") + " ";
        
        
        result += "! ";
        // Print debug info
        for(int i = 0; i < checkTime.size(); i++) {
        	result += checkTime.get(i).getValue() + " ";
		}

        result += "! ";
        for(int i = 0; i < editTime.size(); i++) {
        	result += editTime.get(i).getValue() + " ";
		}

        result += "! ";
        for(int i = 0; i < checkInvalid.size(); i++) {
        	result += checkInvalid.get(i).getValue() + " ";
		}
        result += "! ";
        
        /*
        // remember the extra info you set, they will be printed
        if (memoryBytes2.getValue() != -1) result = result + " " + memoryBytes2.getValue() / 1024;
        if (memoryBytes3.getValue() != -1) result = result + " " + memoryBytes3.getValue() / 1024;
        if (time2.getValue() != -1) result = result + " " + time2;
        if (time3.getValue() != -1) result = result + " " + time3;
        if (time4.getValue() != -1) result = result + " " + time4;
        */
        return result;
	}

    public static double round(double unrounded, int precision, int roundingMode) {
            BigDecimal bd = new BigDecimal(unrounded);
            BigDecimal rounded = bd.setScale(precision, roundingMode);
            return rounded.doubleValue();
    }
	
	// Id
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// filename
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	// scenario
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	// size
	public StampedValue<Integer> getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size.setValue(size);
	}

	// read time
	public StampedValue<Long> getReadTime() {
		return readTime;
	}
	public void setReadTime() {
		setReadTime(System.nanoTime()-startTime);
	}
	public void setReadTime(long readTime) {
		this.readTime.setValue(readTime);
	}

	// check time
	public ArrayList<StampedValue<Long>> getCheckTimes() {
		return checkTime;
	}
	public void addCheckTime() {
		addCheckTime(System.nanoTime()-startTime);
		//System.out.println("CHECK: " + (checkTime.size()-1) + " " + checkTime.get(checkTime.size()-1));
	}
	public void addCheckTime(long time) {
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
		addInvalid(System.nanoTime()-startTime);
	}
	public void addInvalid(long invalids) {
		this.checkInvalid.add(new StampedValue<Long>(invalids));
	}

	// modification time
//	public ArrayList<StampedValue<Long>> getModificationTimes(int index) {
//		return modificationTime;
//	}
//	public void addModificationTime() {
//		addModificationTime(System.nanoTime()-startTime);
//	}
//	public void addModificationTime(long modificationTime) {
//		if (modificationTimeSum == -1L) {
//			modificationTimeSum = 0L;
//		}
//		modificationTimeSum += modificationTime;
//		this.modificationTime.add(new StampedValue<Long>(modificationTime));
//	}
	
	// edit time
	public ArrayList<StampedValue<Long>> getEditTimes() {
		return editTime;
	}
	public void addEditTime() {
		addEditTime(System.nanoTime()-startTime);
	}
	public void addEditTime(long editTime) {
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
	public void addMemoryBytes(long memoryBytes) {
		this.memoryBytes.add(new StampedValue<Long>(memoryBytes));
	}
	
    // nElemToModify
    public ArrayList<StampedValue<Long>> getModifyParams() {
    	return nElemToModify;
    }
    public void addModifyParams(long nElemToModify) {
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
    public void setMemoryBytes2(long memoryBytes2) {
    	this.memoryBytes2.setValue(memoryBytes2);
    }
    
    // memory3
    public StampedValue<Long> getMemoryBytes3() {
    	return memoryBytes3;
    }
    public void setMemoryBytes3(long memoryBytes3) {
    	this.memoryBytes3.setValue(memoryBytes3);
    }
    
    // time2
	public StampedValue<Long> getTime2() {
		return time2;
	}
	public void setTime2() {
		setTime2(System.nanoTime()-startTime);
	}
	public void setTime2(long time2) {
		this.time2.setValue(time2);
	}

	// time3
	public StampedValue<Long> getTime3() {
		return time3;
	}
	public void setTime3() {
		setTime3(System.nanoTime()-startTime);
	}
	public void setTime3(long time3) {
		this.time3.setValue(time3);
	}

	// time4
	public StampedValue<Long> getTime4() {
		return time4;
	}
	public void setTime4() {
		setTime4(System.nanoTime()-startTime);
	}
	public void setTime4(long time4) {
		this.time4.setValue(time4);
	}

	// index
	public StampedValue<Long> getIndex() {
		return index;
	}
	public void setIndex(long index) {
		this.index.setValue(index);
	}
    
    // stopper part
    long startTime;
    public void startStopper() {
    	startTime = System.nanoTime();
    }

    // random
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}

}
