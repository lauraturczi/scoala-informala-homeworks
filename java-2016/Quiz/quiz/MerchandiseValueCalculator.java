package quiz;

public class MerchandiseValueCalculator extends Thread {
	private Package pack;
	private double profit;
	private PackageDistribuitor packages;

	public MerchandiseValueCalculator(Package pack) {
		this.pack = pack;
	}

	@Override
    public void run()
    {
        try
        {
          profit=50;
 
            while (packages.continueProducing)
            {
                Thread.sleep(1000);
                System.out.println("Getting profit " + profit);
 
                profit=profit+0.2f*packages.getPackages().element().getDistance();
            }
 
 
            System.out.println("Total profit per batch " + profit);
        }
        catch (InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
	
	
}
