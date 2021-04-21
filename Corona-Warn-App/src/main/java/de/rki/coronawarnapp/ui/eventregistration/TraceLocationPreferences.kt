package de.rki.coronawarnapp.ui.eventregistration

import android.content.Context
import de.rki.coronawarnapp.util.di.AppContext
import de.rki.coronawarnapp.util.preferences.clearAndNotify
import de.rki.coronawarnapp.util.preferences.createFlowPreference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TraceLocationPreferences @Inject constructor(
    @AppContext val context: Context
) {
    private val prefs by lazy {
        context.getSharedPreferences("trace_location_localdata", Context.MODE_PRIVATE)
    }

    val qrInfoAcknowledged = prefs.createFlowPreference(
        key = "trace_location_qr_info_acknowledged",
        defaultValue = false
    )

    fun clear() {
        prefs.clearAndNotify()
    }
}
