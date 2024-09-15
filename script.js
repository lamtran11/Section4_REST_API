// Fetch employee data from the API
fetch('http://localhost:8080/api/findAll')
  .then((response) => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then((data) => {
    // Get the table body element where rows will be inserted
    const employeeTableBody = document.getElementById('employeeTableBody');

    // Clear existing rows, if any
    employeeTableBody.innerHTML = '';

    // Iterate through the employee data and create table rows
    data.forEach((employee) => {
      // Create a new table row
      const row = document.createElement('tr');

      // Create table cells for employee data and append to the row
      const idCell = document.createElement('td');
      idCell.textContent = employee.id || 'N/A';
      row.appendChild(idCell);

      const firstNameCell = document.createElement('td');
      firstNameCell.textContent = employee.firstName || '(No First Name)';
      if (!employee.firstName) {
        firstNameCell.classList.add('empty-cell');
      }
      row.appendChild(firstNameCell);

      const lastNameCell = document.createElement('td');
      lastNameCell.textContent = employee.lastName || '(No Last Name)';
      if (!employee.lastName) {
        lastNameCell.classList.add('empty-cell');
      }
      row.appendChild(lastNameCell);

      const emailCell = document.createElement('td');
      emailCell.textContent = employee.email || '(No Email)';
      if (!employee.email) {
        emailCell.classList.add('empty-cell');
      }
      row.appendChild(emailCell);

      // Append the new row to the table body
      employeeTableBody.appendChild(row);
    });
  })
  .catch((error) => {
    console.error('Error fetching employee data:', error);
  });

// Function to delete an employee
async function deleteEmployee(employeeId) {
  const confirmation = confirm(
    'Are you sure you want to delete this employee?'
  );

  if (confirmation) {
    try {
      const response = await fetch(
        `http://localhost:8080/api/delete/${employeeId}`,
        {
          method: 'DELETE',
        }
      );

      if (response.ok) {
        alert(`Employee ID ${employeeId} deleted successfully.`);
        document.getElementById(`employee-${employeeId}`).remove();
      } else {
        alert('Failed to delete the employee.');
      }
    } catch (error) {
      console.error('Error:', error);
      alert('An error occurred while deleting the employee.');
    }
  }
}

// Function to fetch employees and render the table
async function fetchEmployees() {
  try {
    const response = await fetch('http://localhost:8080/api/findAll');
    const employees = await response.json();

    const tableBody = document.getElementById('employeeTableBody');
    tableBody.innerHTML = ''; // Clear existing content

    employees.forEach((employee) => {
      const row = `<tr id="employee-${employee.id}">
                            <td>${employee.id}</td>
                            <td>${employee.firstName}</td>
                            <td>${employee.lastName}</td>
                            <td>${employee.email}</td>
                            <td>
                            <button 
                                class="delete-button" 
                                onclick="deleteEmployee(${employee.id})"
                                >Delete</button>
                            </td>
                        </tr>`;

      //
      tableBody.insertAdjacentHTML('beforeend', row);
    });
  } catch (error) {
    console.error('Error fetching employees:', error);
  }
}

// Function to add a new employee
async function addEmployee(event) {
  event.preventDefault();

  const formData = new FormData(document.getElementById('addStudentForm'));
  const employee = {
    firstName: formData.get('firstName'),
    lastName: formData.get('lastName'),
    email: formData.get('email'),
  };

  try {
    const response = await fetch('http://localhost:8080/api/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(employee),
    });

    if (response.ok) {
      alert('Employee added successfully.');
      fetchEmployees();
    } else {
      alert('Failed to add the employee.');
    }
  } catch (error) {
    console.error('Error:', error);
    alert('An error occurred while adding the employee.');
  }
}

// Function to show/hide the form for adding a new employee
document.getElementById('showFormBtn').addEventListener('click', function () {
  const formContainer = document.getElementById('formContainer');
  formContainer.style.display =
    formContainer.style.display === 'none' ? 'block' : 'none';
});

// Add event listener for form submission
document
  .getElementById('addStudentForm')
  .addEventListener('submit', addEmployee);

// Load employees on page load
window.onload = fetchEmployees;
