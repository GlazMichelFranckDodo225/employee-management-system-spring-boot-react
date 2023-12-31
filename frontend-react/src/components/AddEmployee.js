import React, { useState } from 'react'
import EmployeeService from '../services/EmployeeService';

const AddEmployee = () => {
    // Default of an Employeee
    const [employee, setEmployee] = useState({
        "id":"",
        "firstName": "",
        "lastName": "",
        "emailId": ""
    })

    const handleChange = (e) => {
        const value = e.target.value;
        /* I have to set the Employee with the existing Employee */
        setEmployee({...employee, [e.target.name]: value});
    }

    const saveEmployee = (e) => {
        // Disable refreshing of the page
        e.preventDefault();
        // Calling the API Axios
        EmployeeService.saveEmployee(employee).then((response) => {
            console.log(response);
        }).catch((error) => {
            console.log(error);
        });
    };

    return (
        <div className='flex max-w-2xl mx-auto shadow border-b'>
            <div className='px-8 py-8'>
                <div className='font-thin text-2xl tracking-wider'>
                    <h1>Add New Employee</h1>
                </div>
                {/* First Name */}
                <div className='items-center justify-center h-14 w-full my-4'>
                    <label className='block text-gray-600 text-sm font-normal'>First Name</label>
                    <input 
                    type="text" 
                    className='h-10 w-96 border mt-2 px-2 py-2' 
                    name='firstName'
                    value={employee.firstName}
                    onChange={(e) => handleChange(e)}
                    ></input>
                </div>

                {/* Last Name */}
                <div className='items-center justify-center h-14 w-full my-4'>
                    <label className='block text-gray-600 text-sm font-normal'>Last Name</label>
                    <input 
                    type="text" 
                    className='h-10 w-96 border mt-2 px-2 py-2'
                    name='lastName'
                    value={employee.lastName}
                    onChange={(e) => handleChange(e)}
                    ></input>
                </div>

                {/* Email */}
                <div className='items-center justify-center h-14 w-full my-4'>
                    <label className='block text-gray-600 text-sm font-normal'>Email</label>
                    <input 
                    type="email" 
                    className='h-10 w-96 border mt-2 px-2 py-2'
                    name='emailId'
                    value={employee.emailId}
                    onChange={(e) => handleChange(e)}
                    ></input>
                </div>

                {/* Save | Clear */}
                <div className='items-center justify-center h-14 w-full my-4 space-x-4 pt-4'>
                    <button 
                    className='rounded text-white font-semibold bg-green-400 py-2 px-6 hover:bg-green-700'
                    /* On clicking on the "save button":
                        - the "saveEmployee()" function is called,
                        - the "saveEmployee()" function call the "EmployeeService.saveEmployee()" function,
                        - the "EmployeeService.saveEmployee()" function call "axios.post(EMPLOYEE_API_BASE_URL, employee)"
                    */
                    onClick={saveEmployee}
                    >Save</button>
                    <button 
                    className='rounded text-white font-semibold bg-red-400 py-2 px-6 hover:bg-red-700'
                    >Clear</button>
                </div>
            </div>
        </div>
    )
}

export default AddEmployee