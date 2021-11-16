package com.daniel.made1.ui

import android.view.View
import com.daniel.made1.databinding.RateBinding

class RateHelper constructor(private val binding:RateBinding) {

    fun setRate(rate:Float){
        with(binding){
            if (rate < 1.0f){
                starH.visibility = View.VISIBLE
                starI1.visibility = View.GONE
                starI2.visibility = View.VISIBLE
                starI3.visibility = View.VISIBLE
                starI4.visibility = View.VISIBLE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.GONE
                starA2.visibility = View.GONE
                starA3.visibility = View.GONE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate == 1.0f){
                starH.visibility = View.GONE
                starI1.visibility = View.GONE
                starI2.visibility = View.VISIBLE
                starI3.visibility = View.VISIBLE
                starI4.visibility = View.VISIBLE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.GONE
                starA3.visibility = View.GONE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate > 1.0f && rate < 2.0f){
                starH.visibility = View.VISIBLE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.VISIBLE
                starI4.visibility = View.VISIBLE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.GONE
                starA3.visibility = View.GONE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate == 2.0f){
                starH.visibility = View.GONE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.VISIBLE
                starI4.visibility = View.VISIBLE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.GONE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate > 2.0f && rate < 3.0f){
                starH.visibility = View.VISIBLE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.GONE
                starI4.visibility = View.VISIBLE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.GONE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate == 3.0f){
                starH.visibility = View.GONE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.GONE
                starI4.visibility = View.VISIBLE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.VISIBLE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate > 3.0f && rate < 4.0f){
                starH.visibility = View.VISIBLE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.GONE
                starI4.visibility = View.GONE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.VISIBLE
                starA4.visibility = View.GONE
                starA5.visibility = View.GONE
            }else if(rate == 4.0f){
                starH.visibility = View.GONE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.GONE
                starI4.visibility = View.GONE
                starI5.visibility = View.VISIBLE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.VISIBLE
                starA4.visibility = View.VISIBLE
                starA5.visibility = View.GONE
            }else if(rate > 4.0f && rate < 5.0f){
                starH.visibility = View.VISIBLE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.GONE
                starI4.visibility = View.GONE
                starI5.visibility = View.GONE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.VISIBLE
                starA4.visibility = View.VISIBLE
                starA5.visibility = View.GONE
            }else if(rate == 5.0f){
                starH.visibility = View.GONE
                starI1.visibility = View.GONE
                starI2.visibility = View.GONE
                starI3.visibility = View.GONE
                starI4.visibility = View.GONE
                starI5.visibility = View.GONE

                starA1.visibility = View.VISIBLE
                starA2.visibility = View.VISIBLE
                starA3.visibility = View.VISIBLE
                starA4.visibility = View.VISIBLE
                starA5.visibility = View.VISIBLE
            }
        }
    }
}