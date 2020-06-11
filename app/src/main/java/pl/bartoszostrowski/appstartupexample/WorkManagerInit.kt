package pl.bartoszostrowski.appstartupexample

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager

// Initializes WorkManager.
class WorkManagerInit : Initializer<WorkManager> {

    override fun create(context: Context): WorkManager {
        Log.d(TAG, "create()")

        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }

    companion object {
        private const val TAG: String = "WorkManagerInit"
    }
}