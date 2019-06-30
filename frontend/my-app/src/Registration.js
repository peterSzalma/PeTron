import React, {Component} from 'react';
import fire from './config/Fire';

class Registration extends Component{
    constructor(props) {
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.registration = this.registration.bind(this);
        this.state = {
            companyName: '',
            phoneNumber: '',
            email: '',
            password: ''
        };
    }

    handleChange(e) {
        this.setState({[e.target.name] : e.target.value});
    }

    registration(e) {
        e.preventDefault();
    }

}