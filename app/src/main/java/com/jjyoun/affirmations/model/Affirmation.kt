package com.jjyoun.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation (@StringRes val stringResourceId: Int,
                        @DrawableRes val imageResourceId: Int)
    //stringResourceId와 imageResourceId 모두 Integer 타입이라 헷갈릴 수 있으니
    //annotation을 사용한다.
