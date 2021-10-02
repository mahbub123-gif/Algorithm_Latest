
public class knapsack_2 {


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int weights[] = {2,1,3,2};
        int values[] = {12,10,20,15};
        
        int numOfItems = values.length, capOfKP = 5;
        int totalBenefit;
        int KPTable[][] = new int[numOfItems+1][capOfKP+1];
        
        for(int w=0; w<=capOfKP; w++)
        {
            KPTable[0][w] = 0;
        }
        
        for(int i=1; i<=numOfItems; i++)
        {
            KPTable[i][0] = 0;
        }
        
        for(int i=1; i<=numOfItems; i++)
        {
            for(int w=0; w<=capOfKP; w++)
            {
                if(weights[i-1] <= w)
                {
                    if((values[i-1]+KPTable[i-1][w-weights[i-1]]) > (KPTable[i-1][w]))
                    {
                        KPTable[i][w] = values[i-1]+KPTable[i-1][w-weights[i-1]];
                    }
                    
                    else
                    {
                        KPTable[i][w] = KPTable[i-1][w];
                    }
                }
                
                else
                {
                    KPTable[i][w] = KPTable[i-1][w];
                }
            }
        }
        
        System.out.println(KPTable[numOfItems][capOfKP]);
    }
}
