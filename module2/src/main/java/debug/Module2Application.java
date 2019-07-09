package debug;

import com.example.basemodule.base.BaseApplication;
import com.example.basemodule.injection.modules.BaseGlobalModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Xingtian.Xin
 * Date: 2019/7/8
 * Time: 14:25
 */
public class Module2Application extends BaseApplication {
    public static final String TAG = Module2Application.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }

    @Override
    protected String getBaseUrl() {
        return null;
    }

}
