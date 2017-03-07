package quiz;

import java.util.Date;


public class Package extends Thread implements Comparable<Package> {

	private String targetLocation;
	private double distance;
	private double value;
	private Date date;
	private PackageDistribuitor packages;

	public String getTargetLocation() {
		return targetLocation;
	}

	public void setTargetLocation(String targetLocation) {
		this.targetLocation = targetLocation;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Package o) {
		return this.getTargetLocation().compareTo(o.getTargetLocation());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(distance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((targetLocation == null) ? 0 : targetLocation.hashCode());
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (Double.doubleToLongBits(distance) != Double.doubleToLongBits(other.distance))
			return false;
		if (targetLocation == null) {
			if (other.targetLocation != null)
				return false;
		} else if (!targetLocation.equals(other.targetLocation))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}


	 @Override
	    public void run()
	    {
	        try
	        {
	            for (int i = 1; i < 5 + 1; i++)
	            {
	            	Package pack = new Package();
	                System.out.println("Package ready " + i);
	                Thread.sleep(100);
	                packages.addPackage(pack);
	            }
	 
	            this.packages.continueProducing = Boolean.FALSE;
	            System.out.println("No more packages");
	        }
	        catch (InterruptedException ex)
	        {
	            ex.printStackTrace();
	        }
	
	    }

}
