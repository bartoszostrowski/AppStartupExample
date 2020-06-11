package pl.bartoszostrowski.appstartupexample

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import androidx.work.WorkManager

// Initializes ExampleLogger.
class ExampleLoggerInit : Initializer<ExampleLogger> {

    override fun create(context: Context): ExampleLogger {
        Log.d(TAG, "create()")
        return ExampleLogger(WorkManager.getInstance(context))
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // Defines a dependency on WorkManagerInitializer so it can be
        // initialized after WorkManager is initialized.
        return listOf(WorkManagerInit::class.java)
    }

    companion object {
        private const val TAG: String = "ExampleLoggerInit"
    }
}