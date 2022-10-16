package com.example.cgvcloneapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cgvcloneapplication.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewpagerAdapter(this, 3)
        binding.viewPager2.adapter = adapter

        binding.viewPager2TabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let { binding.viewPager2.setCurrentItem(it, false) }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        TabLayoutMediator(binding.viewPager2TabLayout, binding.viewPager2) { tab, position ->
            when(position) {
                0 -> tab.text = "Tab01"
                1 -> tab.text = "Tab02"
                2 -> tab.text = "Tab03"
            }
        }.attach()

    }

    override fun onBackPressed() {
        if(binding.viewPager2.currentItem == 0) {
            super.onBackPressed()
        } else {
            binding.viewPager2.currentItem = binding.viewPager2.currentItem - 1
        }
    }
}