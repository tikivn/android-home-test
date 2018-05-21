package vn.tiki.android.androidhometest.data.api

import org.json.JSONArray
import org.json.JSONObject

fun JSONArray.asSequence(): Sequence<JSONObject> {

  val array = this
  val length = array.length()

  return object : Sequence<JSONObject> {

    override fun iterator() = object : Iterator<JSONObject> {

      var position = 0

      override fun hasNext(): Boolean {
        return length > 0 && position < length
      }

      override fun next(): JSONObject {
        return array.getJSONObject(position++)
      }
    }
  }
}
