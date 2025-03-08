// import React from 'react';

// import { Link } from 'react-router-dom';
// // import ImageSlider from './ImageSlider'; // Make sure to import the ImageSlider component
// import './Home.css';

// function Home() {
//   return (
//     <div className="home-container">
//       <nav className="navbar">
//         <h1 className="navbar-brand">Appointment Booking</h1>
//         <ul className="navbar-nav">
//           <li className="nav-item">
//             <Link to="/login" className="nav-link">Login</Link>
//           </li>
//           <li className="nav-item">
//             <Link to="/registration" className="nav-link">Register</Link>
//           </li>
//           <li className="nav-item">
//             <Link to="/bookAppointment" className="nav-link">Book Appointment</Link>
//           </li>
//         </ul>
//       </nav>
//       <div className="home-content">
//         <h2>Welcome to the Appointment Booking System</h2>
//         <p>Book your appointments easily and quickly.</p>
//         {/* <ImageSlider /> Add the ImageSlider component here */}
//       </div>
//     </div>
//   );
// }

// export default Home;

import React from 'react';
import { Link } from 'react-router-dom';
import './Home.css';
import img1 from './images/img1.jpg';

function Home() {
  return (
    <div className="container-fluid p-0 home-container">
      {/* Main Content with static background image */}
      <div
        className="home-content text-center text-white d-flex flex-column align-items-center justify-content-center"
        style={{ backgroundImage: `url(${img1})` }}
      >
        <h2>Welcome to the Appointment Booking System</h2>
        <div className="row w-100 justify-content-center mt-4">
          <div className="col-md-4">
            <Link to="/login" className="text-decoration-none">
              <div className="card clickable-card">
                <div className="card-body">
                  <h3 className="card-title">Sign In</h3>
                  {/* Additional Sign In details or forms can be added here */}
                </div>
              </div>
            </Link>
          </div>
          <div className="col-md-4">
            <Link to="/registration" className="text-decoration-none">
              <div className="card clickable-card">
                <div className="card-body">
                  <h3 className="card-title">Register</h3>
                  {/* Additional Register details or forms can be added here */}
                </div>
              </div>
            </Link>
          </div>
        </div>
      </div>

      {/* Footer */}
      {/* <footer className="bg-dark text-white text-center py-3 mt-4">
        <div className="container">
          <ul className="nav justify-content-center">
            <li className="nav-item">
              <Link to="/" className="nav-link text-white">
                Home
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/about" className="nav-link text-white">
                About Us
              </Link>
            </li>
          </ul>
        </div>
      </footer> */}
    </div> 
  );
}

export default Home;
