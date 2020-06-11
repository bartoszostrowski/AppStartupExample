package pl.bartoszostrowski.appstartupexample

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import androidx.work.WorkManager

// Initializes ExampleLogger.
class CyclicInit : Initializer<Cyclic> {

    override fun create(context: Context): Cyclic {
        Log.d(TAG, "create()")
        return Cyclic(WorkManager.getInstance(context))
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(CyclicInit::class.java)
    }

    companion object {
        private const val TAG: String = "CyclicInit"
    }
}