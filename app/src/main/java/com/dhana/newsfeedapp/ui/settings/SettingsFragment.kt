package com.dhana.newsfeedapp.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.dhana.newsfeedapp.MainActivity
import com.dhana.newsfeedapp.R
import com.dhana.newsfeedapp.base.BaseFragment
import com.dhana.newsfeedapp.databinding.FragmentSettingsBinding
import com.dhana.newsfeedapp.ui.home.MainViewModel
import com.dhana.newsfeedapp.utils.Constants


/*********************************************************
 * @Class Name:SettingsFragment
 * @Description:To Change the View from Grid to List and Vice Versa
 * *********************************************************/
class SettingsFragment : BaseFragment<FragmentSettingsBinding>() {

    override fun setBinding(): FragmentSettingsBinding =
        FragmentSettingsBinding.inflate(layoutInflater)

    lateinit var viewModel: MainViewModel
    private var TAG: String = SettingsFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel


        if(Constants.view_mode.equals("")||Constants.view_mode.equals("list")){
            binding.rgViewmode.check(R.id.rb_list)
        }else{
            binding.rgViewmode.check(R.id.rb_grid)
        }

        binding.rgViewmode.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.rb_grid) {
                Constants.view_mode = "grid"
                findNavController().navigate(
                    R.id.action_favoriteSettings_to_home
                )
            } else if (checkedId == R.id.rb_list) {
                Constants.view_mode = "list"
                findNavController().navigate(
                    R.id.action_favoriteSettings_to_home
                )
            }
        })

    }
}