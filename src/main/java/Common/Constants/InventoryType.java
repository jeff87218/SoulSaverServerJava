package Common.Constants;

public final class InventoryType
{
    public enum EquipType
    {
        Weapon((byte)0), // 武器[Weapon]
        Outfit((byte)1), // 衣服[Outfit]
        Ring((byte)2), // 戒指[Ring]
        Necklace((byte)3), // 項鍊[Necklace]
        Mantle((byte)4), // 披風[Mantle]
        Seal((byte)5), // 封印物[Seal]
        Hat((byte)6), // 頭部[Hat]
        Hair((byte)7), // 頭髮[Hair]
        Eyes((byte)8), // 眼睛[Eyes]
        Face((byte)9), // 臉上[Face]
        Pet((byte)10), // 靈物[Pet]
        Dress((byte)11), // 服裝[Dress]
        Face2((byte)12), // 臉下[Face2]
        Earing((byte)13), // 耳環[Earing]
        HairAcc((byte)14), // [HairAcc]
        Toy((byte)15); // 玩物[Toy]


        private byte byteValue;


        private EquipType(byte value)
        {
            byteValue = value;
        }

        public byte getValue()
        {
            return byteValue;
        }

    }

    public enum ItemType
    {
        Undefined((byte)0xFF),
        Equip((byte)0),
        Equip1((byte)1), // [1]
        Equip2((byte)2), // [2]
        Spend3((byte)3), // [3]
        Other4((byte)4), // [4]
        Pet5((byte)5), // [5]
        Cash((byte)6); // [購物商城倉庫]


        private byte byteValue;


        private ItemType(byte value)
        {
            byteValue = value;
        }

        public byte getValue()
        {
            return byteValue;
        }

    }

    public static byte getItemType(int itemid)
    {
        byte type = 0;

        switch (itemid / 100000)
        {
            case 79: // 武器
            case 80: // 武器
            case 81: // 衣服
            case 93: // 武器
            case 95: // 服裝
                type = 1;
                break;
            case 75: // 耳環
            case 82: // 戒指
            case 83: // 項鍊
            case 84: // 披風
            case 85: // 封印箱
            case 86: // 頭部
            case 87: // 臉上
            case 94: // 臉下
                type = 2;
                break;
            case 11: // 拼圖
            case 88: // 消耗
                type = 3;
                break;
            case 89: // 其他
                type = 4;
                break;
            case 92: // 寵物
                type = 5;
                break;
        }
        return type;
    }

    // 武士
    public static boolean Is劍(int ItemID)
    {
        if (ItemID >= 8010011 && ItemID <= 8011531)
        {
            return true;
        }
        return false;
    }

    public static boolean Is刀(int ItemID)
    {
        if (ItemID >= 8020101 && ItemID <= 8021531)
        {
            return true;
        }
        return false;
    }

    // 刺客
    public static boolean Is爪(int ItemID)
    {
        if (ItemID >= 8030011 && ItemID <= 8031531)
        {
            return true;
        }
        return false;
    }

    public static boolean Is手套(int ItemID)
    {
        if (ItemID >= 8040101 && ItemID <= 8041531)
        {
            return true;
        }
        return false;
    }

    // 道士
    public static boolean Is扇(int ItemID)
    {
        if (ItemID >= 8050101 && ItemID <= 8051531)
        {
            return true;
        }
        return false;
    }

    public static boolean Is杖(int ItemID)
    {
        if (ItemID >= 8060011 && ItemID <= 8061531)
        {
            return true;
        }
        return false;
    }

    // 力士
    public static boolean Is斧(int ItemID)
    {
        if (ItemID >= 8070011 && ItemID <= 8071531)
        {
            return true;
        }
        return false;
    }

    public static boolean Is輪(int ItemID)
    {
        if (ItemID >= 8080101 && ItemID <= 8081531)
        {
            return true;
        }
        return false;
    }

    public static int getMoneyStyle(int money)
    {
        if (money > 0 && money <= 51)
        {
            return 9800001; // 銅錢
        }
        else if (money > 51 && money <= 500)
        {
            return 9800002; // 銀錢
        }
        else if (money > 500 && money <= 1000)
        {
            return 9800003; // 金錢
        }
        else if (money > 1000 && money <= 5000)
        {
            return 9800004; // 銀元寶
        }
        return 9800005; // 金元寶
    }
}