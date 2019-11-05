package model;

public class Price {
    private static final int NORMAL_NON_SPECIAL = 7;
    private static final int NORMAL_SPECIAL = 8;
    private static final int VIP_SPECIAL = 10;
    private static final int VIP_NON_SPECIAL = 9;

    public static int getPrice(boolean vipSeat, boolean specialTime, boolean discount){
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
        return price;
    }
}