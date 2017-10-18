//package muhanxi.myapplication.wxapi;
//
//
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//
//import com.tencent.mm.opensdk.constants.ConstantsAPI;
//import com.tencent.mm.opensdk.modelbase.BaseReq;
//import com.tencent.mm.opensdk.modelbase.BaseResp;
//import com.tencent.mm.opensdk.openapi.IWXAPI;
//import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
//import com.tencent.mm.opensdk.openapi.WXAPIFactory;
//
//import muhanxi.myapplication.R;
//
//public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
//
//	private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";
//
//    private IWXAPI api;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.pay_result);
//
////    	api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
////        api.handleIntent(getIntent(), this);
//    }
//
//	@Override
//	protected void onNewIntent(Intent intent) {
//		super.onNewIntent(intent);
//		setIntent(intent);
//        api.handleIntent(intent, this);
//	}
//
//	@Override
//	public void onReq(BaseReq req) {
//	}
//
//	@Override
//	public void onResp(BaseResp resp) {
////		Log.d(TAG, "onPayFinish, errCode = " + resp.errCode);
//
//		if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
//			 int errCode = resp.errCode ;
////0	成功	展示成功页面
////			-1	错误	可能的原因：签名错误、未注册APPID、项目设置APPID不正确、注册的APPID与设置的不匹配、其他异常等。
////			-2	用户取消
////			AlertDialog.Builder builder = new AlertDialog.Builder(this);
////			builder.setTitle(R.string.app_tip);
////			builder.setMessage(getString(R.string.pay_result_callback_msg, String.valueOf(resp.errCode)));
////			builder.show();
//		}
//	}
//}