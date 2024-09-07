
function toggleSelection(selectAllCheckbox) {
    const checkboxes = document.querySelectorAll('.student_checkbox');
    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAllCheckbox.checked;
    });
}
