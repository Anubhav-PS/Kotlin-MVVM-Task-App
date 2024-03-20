package com.anubhav.mytasks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import com.anubhav.mytasks.R
import com.anubhav.mytasks.databinding.FragmentAddNewTaskBinding
import com.anubhav.mytasks.models.TaskItem
import com.anubhav.mytasks.viewmodels.MainViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddNewTaskFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddNewTaskBinding
    private lateinit var rootView: View
    private val priorityLevels = listOf("HIGH", "MEDIUM", "LOW")
    private var selectedPriorityIndex = 0

    private val mainViewModel: MainViewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNewTaskBinding.inflate(inflater, container, false)
        rootView = binding.root
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {


            val inputTaskName = binding.taskNameInputEditText.text.toString().trim()

            if (inputTaskName.isBlank()) {
                binding.taskNameInputLayout.error = "Please enter task name"
            }


            binding.taskNameInputLayout.error = null
            dismiss()
            mainViewModel.insertTaskItem(TaskItem(inputTaskName,selectedPriorityIndex))
        }

        //create an adapter to bind the priority list to the drop down layout
        val dropDownAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, priorityLevels)
        //add the adapter to the drop down view
        binding.taskPriorityInputAutoComplete.setAdapter(dropDownAdapter)
        //listen to the item being selected or clicked in the drop down
        binding.taskPriorityInputAutoComplete.setOnItemClickListener { _, _, position, _ ->
            selectedPriorityIndex = position
        }

    }

}