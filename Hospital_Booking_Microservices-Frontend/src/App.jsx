import React, { useContext } from 'react';
import { Link, Route, Routes, useNavigate } from 'react-router-dom';
import { AuthProvider, AuthContext } from './AuthContext';
import Home from './Bookings/Home';
import Signin from './Bookings/Signin';
import Registration from './Bookings/Registration';
import BookAppointment from './Bookings/BookAppointment';
import Hospital from './Bookings/Hospital';
import Depatment from './Bookings/Depatment';
import BookingDetails from './Bookings/BookingDetails';
import './App.css';
import AboutUs from './Bookings/AboutUs';

function Navigation() {
  const { auth, setAuth } = useContext(AuthContext);
  const navigate = useNavigate();

  const logoutHandler = () => {
    // Clear authentication details from context (and localStorage if needed)
    setAuth({});
    localStorage.removeItem('patientId');
    // Redirect to login page
    navigate('/login');
  };
  const alertUser = () => {
    window.alert("are you sure");
  }

  return (
    <nav className="navbar navbar-expand-sm bg-dark navbar-dark">
      <div className="container-fluid">
        <ul className="navbar-nav">
          <li className="nav-item">
            <Link className="nav-link" to="/home">
              Home
            </Link>
          </li>
          {auth && auth.token ? (
            <>
              <li className="nav-item">
                <Link className="nav-link" to="/booking">
                  Booking Details
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/bookAppointment">
                  Book Appointment
                </Link>
              </li>
              {auth.role === 'ADMIN' && (
                <>
                  <li className="nav-item">
                    <Link className="nav-link" to="/hospital">
                      Hospital
                    </Link>
                  </li>
                  <li className="nav-item">
                    <Link className="nav-link" to="/department">
                      Department
                    </Link>
                  </li>
                </>
              )}
              <li className="nav-item">
                <button
                  className="nav-link btn btn-link"
                  onClick={logoutHandler}
                  style={{ cursor: 'pointer' }}
                >
                  Logout
                </button>
              </li>
              <li className="nav-item">
                <button
                  className="nav-link btn btn-link"
                  onClick={alertUser}
                >
                  Alert
                </button>
              </li>
            </>
          ) : (
            <>
              <li className="nav-item">
                <Link className="nav-link" to="/login">
                  Login
                </Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/registration">
                  Registration
                </Link>
              </li>
            </>
          )}
        </ul>
      </div>
    </nav>
  );
}

function App() {
  return (
    <AuthProvider>
      <div align="center" className="app-container">
        <Navigation />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/login" element={<Signin />} />
          <Route path="/registration" element={<Registration />} />
          <Route path="/bookAppointment" element={<BookAppointment />} />
          <Route path="/hospital" element={<Hospital />} />
          <Route path="/booking" element={<BookingDetails />} />
          <Route path="/department" element={<Depatment />} />
          <Route path="/about" element={<AboutUs />} />
        </Routes>
        {/* Footer */}
        <footer className="bg-dark text-white text-center py-3 mt-4">
          <div className="container">
            <ul className="nav justify-content-center">
              <li className="nav-item">
                <Link to="/about" className="nav-link text-white">
                  About Us
                </Link>
              </li>
            </ul>
          </div>
        </footer>
      </div>
    </AuthProvider>
  );
}

export default App;
