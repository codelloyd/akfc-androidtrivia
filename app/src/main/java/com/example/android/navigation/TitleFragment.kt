package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
      inflater,
      R.layout.fragment_title,
      container,
      false
    )

    binding.playButton.setOnClickListener { view: View ->
      view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
    }
    setHasOptionsMenu(true)

    return binding.root
  }

  override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
    super.onCreateOptionsMenu(menu, inflater)
    inflater?.inflate(R.menu.options_menu, menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    return NavigationUI.onNavDestinationSelected(
      item!!,
      view!!.findNavController()
    ) || super.onOptionsItemSelected(item)
  }
}
