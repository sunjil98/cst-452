/*I have used following youtube channel as resource for this project. https://www.youtube.com/channel/UCnj8dl6NWgASf4kKZLuuwfw */
import React, {Component} from 'react';
import {Grid, Cell, List, ListItem,ListItemContent } from 'react-mdl';

class Contact extends Component
{
  render()
  {
    return(
      <div className="contact-body">
        <Grid className="contact-grid">
          <Cell col={6}>
            <h2>Sunjil Gahatraj</h2>
            <img
              src="https://www.nicepng.com/png/full/73-735136_one-guy-web-developer-avatar.png"
              alt="avatar"
              style={{height: '250px'}}
               />
             <h2 style={{ width: '75%', margin: 'auto', paddingTop: '1em'}}>
             Software Developer
             </h2>
          </Cell>
          <Cell col={6}>
            <h2>Contact Me</h2>
            <hr/>
            <div className="contact-list">
            <List>
                  <ListItem>
                  <ListItemContent style={{fontSize:'25px', fontFamily:'Anton'}}>
                  <i className="fa fa-phone-square" aria-hidden="true"/>
                     (602) 299 9769
                  </ListItemContent>
                  </ListItem>

                  <ListItem>
                  <ListItemContent style={{fontSize:'25px', fontFamily:'Anton'}}>
                  <i className="fa fa-envelope-square" aria-hidden="true"/>
                     sunjilgahatraj1@gmail.com
                  </ListItemContent>
                  </ListItem>

                  <ListItem>
                  <ListItemContent style={{fontSize:'25px', fontFamily:'Anton'}}>
                  <i className="fa fa-linkedin-square" aria-hidden="true"/>
                  https://www.linkedin.com/in/sunjil-gahatraj-a44256158/
                  </ListItemContent>
                  </ListItem>
            </List>
            </div>
          </Cell>
        </Grid>
      </div>
    )
  }
}

export default Contact;
