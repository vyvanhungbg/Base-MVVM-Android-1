package com.tieuvy.android.base_mvvm_android_1.data.datasource.remote.api.url

import io.ktor.resources.Resource

@Resource("/search")
class ApiSearch() {
    @Resource("/users")
    class User(val q: String? = "abc",val parent: ApiSearch = ApiSearch(),)
}