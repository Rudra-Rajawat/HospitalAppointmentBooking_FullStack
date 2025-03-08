import React from 'react';

const AboutUs = () => {
  return (
    <div className="container mt-5">
      <h1 className="mb-4">About Us</h1>
      <p className="lead">
        Welcome to our Hospital Appointment Site. We are dedicated to providing you with the best healthcare services. Our platform allows you to book appointments with top doctors, view your medical records, and receive timely reminders for your appointments.
      </p>
      <h2 className="mt-4">Contact Us</h2>
      <p>
        For complaints and feedback, please email us at: <a href="mailto:feedback@hospitalappointmentsite.com">feedback@hospitalappointmentsite.com</a>
      </p>
      <p>
        You can also reach us at: <strong>+1-234-567-890</strong>
      </p>
    </div>
  );
};

export default AboutUs;
