package debug;

import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;
import com.example.module1.injection.DaggerModule1Component;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/8
 * Time: 13:42
 */
public class Module1Application extends BaseApplication {
    public static final String TAG = Module1Application.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected String getBaseUrl() {
        return null;
    }

    @Override
    protected void injectApp() {
        DaggerModule1Component.builder()
                .baseGlobalModule(new BaseGlobalModule(this))
                .build()
                .inject(this);
    }
}
