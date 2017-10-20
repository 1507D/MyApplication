package muhanxi.myapplication.shop;

import java.util.List;

/**
 * Created by muhanxi on 17/6/21.
 */

public class ShopBean {


    /**
     * code : 200
     * orderData : [{"shopId":1,"shopName":"京东自营","cartlist":[{"id":1,"shopId":1,"shopName":"京东自营","defaultPic":"https://img30.360buyimg.com/popWareDetail/jfs/t3208/194/7616404169/244198/369625db/58b7d093N03520fb7.jpg","productId":1,"productName":"三只松鼠_零食大礼包","color":null,"size":null,"price":20,"count":2},{"id":2,"shopId":1,"shopName":"京东自营","defaultPic":"https://img14.360buyimg.com/n0/jfs/t2971/15/167732091/93002/204c1016/574d9d9aNe4e6fa7a.jpg","productId":2,"productName":null,"color":null,"size":null,"price":148,"count":3}]},{"shopId":2,"shopName":"海澜之家","cartlist":[{"id":1,"shopId":2,"shopName":"海澜之家","defaultPic":"https://img30.360buyimg.com/popWaterMark/jfs/t4075/83/1343091204/132469/9034cb9c/5873496bN68020ba8.jpg","productId":1,"productName":"短袖T恤男 2017夏季新品","color":null,"size":null,"price":181,"count":1}]}]
     */

    private int code;
    private List<OrderDataBean> orderData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<OrderDataBean> getOrderData() {
        return orderData;
    }

    public void setOrderData(List<OrderDataBean> orderData) {
        this.orderData = orderData;
    }

    public static class OrderDataBean {
        /**
         * shopId : 1
         * shopName : 京东自营
         * cartlist : [{"id":1,"shopId":1,"shopName":"京东自营","defaultPic":"https://img30.360buyimg.com/popWareDetail/jfs/t3208/194/7616404169/244198/369625db/58b7d093N03520fb7.jpg","productId":1,"productName":"三只松鼠_零食大礼包","color":null,"size":null,"price":20,"count":2},{"id":2,"shopId":1,"shopName":"京东自营","defaultPic":"https://img14.360buyimg.com/n0/jfs/t2971/15/167732091/93002/204c1016/574d9d9aNe4e6fa7a.jpg","productId":2,"productName":null,"color":null,"size":null,"price":148,"count":3}]
         */

        private int shopId;
        private String shopName;
        private List<CartlistBean> cartlist;

        public int getShopId() {
            return shopId;
        }

        public void setShopId(int shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public List<CartlistBean> getCartlist() {
            return cartlist;
        }

        public void setCartlist(List<CartlistBean> cartlist) {
            this.cartlist = cartlist;
        }

        public static class CartlistBean {
            /**
             * id : 1
             * shopId : 1
             * shopName : 京东自营
             * defaultPic : https://img30.360buyimg.com/popWareDetail/jfs/t3208/194/7616404169/244198/369625db/58b7d093N03520fb7.jpg
             * productId : 1
             * productName : 三只松鼠_零食大礼包
             * color : null
             * size : null
             * price : 20
             * count : 2
             */

            private int id;
            private int shopId;
            private String shopName;
            private String defaultPic;
            private int productId;
            private String productName;
            private Object color;
            private Object size;
            private int price;
            private int count;

            //商品是否被选中
            private boolean isSelect = false;
            //是否是第一个 如果isfirst 等于1 显示商户的名称， 否则隐藏商户的名称
            private int isFirst = 2;
            //商户是否被选中
            private boolean isShopSelect = true;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getDefaultPic() {
                return defaultPic;
            }

            public void setDefaultPic(String defaultPic) {
                this.defaultPic = defaultPic;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public Object getColor() {
                return color;
            }

            public void setColor(Object color) {
                this.color = color;
            }

            public Object getSize() {
                return size;
            }

            public void setSize(Object size) {
                this.size = size;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }


            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            public int getIsFirst() {
                return isFirst;
            }

            public void setIsFirst(int isFirst) {
                this.isFirst = isFirst;
            }

            public boolean isShopSelect() {
                return isShopSelect;
            }

            public void setShopSelect(boolean shopSelect) {
                isShopSelect = shopSelect;
            }
        }
    }
}
