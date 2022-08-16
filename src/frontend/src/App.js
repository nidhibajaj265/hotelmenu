import React from 'react';
import './App.css';
import {Container, Row} from 'react-bootstrap'

import NavigationBar from './components/NavigationBar';

function App() {
  return (
    <div className="App">
        <NavigationBar/>
        <Container>
            <Row>
                <div class="bg-light p-5 rounded-lg m-3">
                  <h1 class="display-4">Hello, world!</h1>
                  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
                  <hr class="my-4"></hr>
                  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
                </div>
            </Row>
        </Container>
    </div>
  );
}

export default App;
