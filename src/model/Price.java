package model;

/**
 * contains all required price operations
 * @author Phung Minh Khanh
 */
public class Price {
    private static final int NORMAL_NON_SPECIAL = 7;
    private static final int NORMAL_SPECIAL = 8;
    private static final int VIP_SPECIAL = 10;
    private static final int VIP_NON_SPECIAL = 9;
    public static final int POPCORN = 3;
    public static final int DRINK = 2;

    /**
     * @param vipSeat
     * @param specialTime
     * @param discount
     * @param cinemaClass
     * @return price with specific information
     */
    public static int getPrice(boolean vipSeat, boolean specialTime, boolean discount, int cinemaClass){
        int price = NORMAL_NON_SPECIAL;
        if(vipSeat && specialTime){
            price = VIP_SPECIAL;
        }
        else if(vipSeat && !specialTime){
            price = VIP_NON_SPECIAL;
        }
        else if(!vipSeat && specialTime){
            price = NORMAL_SPECIAL;
        }

        if(discount){
            price -= 1;
        }

        if(cinemaClass > 1){
            price += cinemaClass;
        }
        return price;
    }

    /**
     * display price information
     */
    public static void displayPrice(){
        System.out.println("Normal seat, non special day: " + NORMAL_NON_SPECIAL + "S$");
        System.out.println("Normal seat, special day(including holiday, weekend and sneak show): " + NORMAL_SPECIAL + "S$");
        System.out.println("VIP seat(row E, F, G), non special day: " + VIP_NON_SPECIAL + "S$");
        System.out.println("VIP seat(row E, F, G), special day(including holiday, weekend and sneak show): " + VIP_SPECIAL + "S$");
        System.out.println("Students, seniors are discounted by 1 S$");
    }
}
