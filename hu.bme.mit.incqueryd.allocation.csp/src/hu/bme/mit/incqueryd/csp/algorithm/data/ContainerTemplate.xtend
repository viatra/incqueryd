package hu.bme.mit.incqueryd.csp.algorithm.data

@Data
class ContainerTemplate extends AbstractContainer implements Comparable<ContainerTemplate>{
	long id
	
	override compareTo(ContainerTemplate o) {
		val double priceValueRatio_this = (this.memoryCapacity / this.cost);
		val double priceValueRatio_other = o.memoryCapacity / o.cost;
		
		if (priceValueRatio_this == priceValueRatio_other) return 0
		else if (priceValueRatio_this > priceValueRatio_other) return -1
		
		return 1
		
	}
	
}