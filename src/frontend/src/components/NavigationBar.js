import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from './MasalaKitchenLogo.png';


class NavigationBar extends React.Component{
    render(){
        return(
        <Navbar bg="light" variant="light">
           <Navbar.Brand href="/">
                <img src={logo} alt="logo" / >
          </Navbar.Brand>
                <Nav className="navigationBar">
                    <Nav.Link href="#home">Home</Nav.Link>
                    <Nav.Link href="#menu">Menu</Nav.Link>
                    <Nav.Link href="#login">Login</Nav.Link>
                    <Nav.Link href="#signup">Signup</Nav.Link>
                  </Nav>
        </Navbar>
        )

    }
}

export default NavigationBar;  //allow other classes to import this class