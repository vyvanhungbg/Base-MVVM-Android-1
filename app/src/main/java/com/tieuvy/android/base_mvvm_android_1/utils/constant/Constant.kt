package com.tieuvy.android.base_mvvm_android_1.utils.constant

object Constant {

    const val PROJECT_NAME = "com.tieuvy.android.base_mvvm_android_1."

    object API {
        const val BASE = "https://api.github.com"
        const val SEARCH_USER = "/search/users"
    }

    object DELAY {
        const val INPUT_TEXT = 600L
    }

    object DEFAULT {

    }

    object DB {
        const val VERSION = 1
        const val NAME = "LICENSE_DRIVE"
        const val PATH = "databases/database.db"

        object TABLES {
            const val USER = "user"
        }
    }


    object PATH_ASSERT {
        private const val BASE = "file:///android_asset/"

    }

    object TIME {
        const val SECOND_TO_MILLI = 1000L
    }

    object SHAREDPREF {
        const val ROOT = PROJECT_NAME.plus("SHARED_FILE")

    }

}