package com.dhana.newsfeedapp.ui.details

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.core.view.isGone
import androidx.navigation.fragment.navArgs
import com.dhana.newsfeedapp.MainActivity
import com.dhana.newsfeedapp.base.BaseFragment
import com.dhana.newsfeedapp.databinding.FragmentDetailsBinding
import com.dhana.newsfeedapp.ui.home.MainViewModel
import com.dhana.newsfeedapp.utils.Utilsapp
import com.google.android.material.snackbar.Snackbar

class ViewNewsFragment : BaseFragment<FragmentDetailsBinding>() {

    override fun setBinding(): FragmentDetailsBinding =
        FragmentDetailsBinding.inflate(layoutInflater)

    lateinit var viewModel: MainViewModel

    val args: ViewNewsFragmentArgs by navArgs()
    private var TAG:String=ViewNewsFragment::class.java.simpleName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).mainViewModel
        setupUI(view)
        setupObserver()
    }

    private fun setupUI(view: View) {
        val news = args.news
        binding.webView.apply {
            webViewClient = WebViewClient()
            news.url?.let {
                loadUrl(it)
            }
        }

        binding.fab.setOnClickListener {
            viewModel.saveNews(news)
            Snackbar.make(view, "News article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupObserver() {
        viewModel.getFavoriteNews().observe(viewLifecycleOwner, { news ->
            binding.fab.isGone = news.any { it.title == args.news.title }
        })
    }
}