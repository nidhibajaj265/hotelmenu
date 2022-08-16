import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';


class NavigationBar extends React.Component{
    render(){
        return(
        <Navbar bg="dark" variant="dark">
            <Container>
                <Nav className="navigationBar">
                    <Nav.Link href="#home">Home</Nav.Link>
                    <Nav.Link href="#menu">Menu</Nav.Link>
                    <Nav.Link href="#login">Login</Nav.Link>
                    <Nav.Link href="#signup">Signup</Nav.Link>
                  </Nav>
            </Container>
        </Navbar>
        )

    }
}

export default NavigationBar;  //allow other classes to import this class