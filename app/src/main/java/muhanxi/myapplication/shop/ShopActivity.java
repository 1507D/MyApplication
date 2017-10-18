package muhanxi.myapplication.shop;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import muhanxi.myapplication.R;


public class ShopActivity extends Activity {


    @BindView(R.id.third_recyclerview)
    RecyclerView thirdRecyclerview;
    @BindView(R.id.third_allselect)
    TextView thirdAllselect;
    @BindView(R.id.third_totalprice)
    TextView thirdTotalprice;
    @BindView(R.id.third_totalnum)
    TextView thirdTotalnum;
    @BindView(R.id.third_submit)
    TextView thirdSubmit;
    @BindView(R.id.third_pay_linear)
    LinearLayout thirdPayLinear;
    private ThirdFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        // 1 选中 2 未选中
        thirdAllselect.setTag(1);

        showData();

    }


    //存放购物车中所有的商品
    private List<ShopBean.OrderDataBean.CartlistBean> mAllOrderList = new ArrayList<>();

    private void showData() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ThirdFragmentAdapter(this);
        thirdRecyclerview.setAdapter(adapter);
        thirdRecyclerview.setLayoutManager(linearLayoutManager);


        try {
            InputStream inputStream = getAssets().open("shop.json");
            String data = StringUtils.convertStreamToString(inputStream);
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(data, ShopBean.class);


            for (int i = 0; i < shopBean.getOrderData().size(); i++) {
                int length = shopBean.getOrderData().get(i).getCartlist().size();
                for (int j = 0; j < length; j++) {
                    mAllOrderList.add(shopBean.getOrderData().get(i).getCartlist().get(j));
                }
            }
            setFirstState(mAllOrderList);

            adapter.setData(mAllOrderList);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //删除数据回调
        adapter.setOnDeleteClickListener(new ThirdFragmentAdapter.OnDeleteClickListener() {
            @Override
            public void onDeleteClick(View view, int position, int cartid) {


            }
        });


        //
        adapter.setOnRefershListener(new ThirdFragmentAdapter.OnRefershListener() {
            @Override
            public void onRefersh(boolean isSelect, List<ShopBean.OrderDataBean.CartlistBean> list) {

                //标记底部 全选按钮
                if (isSelect) {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    thirdAllselect.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
                } else {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    thirdAllselect.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
                }

                //总价
                float mTotlaPrice = 0f;
                int mTotalNum = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isSelect()) {
                        mTotlaPrice += list.get(i).getPrice() * list.get(i).getCount();
                        mTotalNum += list.get(i).getCount();
                    }
                }
                System.out.println("mTotlaPrice = " + mTotlaPrice);

                thirdTotalprice.setText("总价 : " + mTotlaPrice);

                thirdTotalnum.setText("共" + mTotalNum + "件商品");
            }
        });


    }

    /**
     * 标记第一条数据 isfirst 1 显示商户名称 2 隐藏
     *
     * @param list
     */
    public static void setFirstState(List<ShopBean.OrderDataBean.CartlistBean> list) {

        if (list.size() > 0) {
            list.get(0).setIsFirst(1);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i).getShopId() == list.get(i - 1).getShopId()) {
                    list.get(i).setIsFirst(2);
                } else {
                    list.get(i).setIsFirst(1);
                }
            }
        }

    }

    @OnClick({R.id.third_allselect, R.id.third_totalprice, R.id.third_totalnum, R.id.third_submit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.third_allselect:

                // 全选
                int state = (Integer)  thirdAllselect.getTag() ;

                adapter.setUnSelected(state);
                if(state == 1){
                    thirdAllselect.setTag(2);
                }else {
                    thirdAllselect.setTag(1);
                }





                break;
            case R.id.third_totalprice:
                break;
            case R.id.third_totalnum:
                break;
            case R.id.third_submit:
                break;
        }
    }
}
