package vn.tiki.android.androidhometest

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import vn.tiki.android.androidhometest.data.api.ApiServices
import vn.tiki.android.androidhometest.data.api.response.Deal
import vn.tiki.android.androidhometest.di.initDependencies
import vn.tiki.android.androidhometest.di.inject
import vn.tiki.android.androidhometest.di.releaseDependencies

class MainActivity : AppCompatActivity() {

  val apiServices by inject<ApiServices>()

  private var task: AsyncTask<Unit, Unit, List<Deal>>? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    initDependencies(this)
    setContentView(R.layout.activity_main)

    val deals = apiServices.getDeals()

    task = object : AsyncTask<Unit, Unit, List<Deal>>() {
      override fun doInBackground(vararg params: Unit?): List<Deal> {
        return deals
      }

      override fun onPostExecute(result: List<Deal>?) {
        super.onPostExecute(result)
        result.orEmpty()
            .forEach { deal ->
              println(deal)
            }
      }
    }.execute()
  }

  override fun onDestroy() {
    super.onDestroy()
    releaseDependencies()
    task?.cancel(true)
  }
}
