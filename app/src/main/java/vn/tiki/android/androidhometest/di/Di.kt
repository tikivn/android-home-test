package vn.tiki.android.androidhometest.di

import android.content.Context
import vn.tiki.android.androidhometest.data.api.ApiServices

private val factories = mutableMapOf<Class<*>, Factory<*>>()

fun initDependencies(context: Context) {
  provide { ApiServices(context) }
}

fun releaseDependencies() {
  factories.clear()
}

fun <T> put(clazz: Class<T>, factory: Factory<T>) {
  factories[clazz] = factory
}

@Suppress("UNCHECKED_CAST")
fun <T> get(clazz: Class<T>): Lazy<T> = lazy {
  factories[clazz]?.invoke() as T ?: throw IllegalStateException("no Factory for $clazz")
}

inline fun <reified T> provide(noinline factory: Factory<T>) = put(T::class.java, factory)

inline fun <reified T> inject() = get(T::class.java)
