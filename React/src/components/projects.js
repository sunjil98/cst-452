/*I have used following youtube channel as resource for this project. https://www.youtube.com/channel/UCnj8dl6NWgASf4kKZLuuwfw */
import React, {Component} from 'react';
import {Tabs, Tab, Grid, Cell, Card, CardTitle,CardActions, CardText,Button, CardMenu, IconButton} from 'react-mdl';
import Education from './education';


class Projects extends Component
{
  constructor(props)
  {
    super(props);
    this.state= {activeTab:0};
  }
/*This is catgegories for all the projects tabs*/
 toggleCategories() {
  if(this.state.activeTab===0)
  {
    return(
      <div>
      <Grid>
      <Cell className="project-col" col={12}>
<div className="project-text">
        <h1>Lets's Fly</h1>
        <div className="topic-header">
        <h5>Introduction</h5>
        <br/>
        <p>Lets fly is my senior year capstone project. This is an airlines ticket booking website developed in Spring MVC framework.
        I choose to work on this project because of my love toward aviation.
        I started working on this project from the first semester of my final yeare at Grand Canyon University. We as a class tried
        to implement all the skills we learned through out the year in our classes and incorporate them in our final year project.
        To follow general Software developoment practice, I started my project with requirement. I visited different airlines ticket booking sites like skiplegged,
        expedia, and orbit to have a feel of what are the things I need to be aware about while working on a project. I gathered all functional, non-functional, and
        techincal requirement as much as I can, which did change later on during design and development phase. Second step was planning, in this phase
        I planned by approach. I designed workbreak down chart, lean canvas, and project propsal document. Project proposal document later on became base
        of design document. I started using spring back log and product back log to keep track of my progress. Third step was design. In this stage, I designed
        the detail architect of the applicaton, technology needed, class diagram, sequence diagram, and also did proof of concept to make sure everything is in place.
        Fourt step was developement and testing, I started this phase at the end of first of two semesters. The aproach was to add component and functionality to
        the application and perform testing. I had seperate chart to keep track of all the testing and result so that I can follow them later if needed. I also had
        tracibility matrix to keep track of over of testing process.
        </p>
        <br/>
        <h5>Some of the technolgy used</h5>
          1. Spring Framework 5.0
          <br/>
          2. Tomcat Server 8.5 <br/> 3. MySQL database <br/>
          4. Java Version 7<br/> 5. Apache Tile <br/>
          6. JSP Standard Tag Library (JSTL) <br/>
          7. Bootstrap <br/>
          8. MVC Desgin Pattern
          9. PayPal API <br/>

      <h5>Some diagram</h5>
        </div>
        <div>
        <img
          src="https://scontent.fphx1-2.fna.fbcdn.net/v/t1.15752-9/56835659_791908511181392_6662840439105650688_n.png?_nc_cat=102&_nc_ht=scontent.fphx1-2.fna&oh=5f6016ce59aa3f2a2a07f911e5902718&oe=5D45EE19"
          alt="avatar"
          style={{height: '300px', width:'1000px'}}
           />
           </div>
           <br/>
           <div>
           <img
             src="https://scontent.fphx1-2.fna.fbcdn.net/v/t1.15752-9/56899540_645695689196140_8134609436615376896_n.png?_nc_cat=105&_nc_ht=scontent.fphx1-2.fna&oh=b44e65e874d662012a3b388332965099&oe=5D465C0C"
             alt="avatar"
             style={{height: '300px', width:'1000px'}}
              />
              </div>
              <br/>
              <div>
              <img
                src="https://scontent.fphx1-2.fna.fbcdn.net/v/t1.15752-9/57038249_407414746743760_1061567550220926976_n.png?_nc_cat=105&_nc_ht=scontent.fphx1-2.fna&oh=6a61864efa7c4a6faea42163c4c085f0&oe=5D4A192E"
                alt="avatar"
                style={{height: '300px', width:'1000px'}}
                 />
                 </div>
                 <br/>
                 <h2>Please follow these links for more </h2>
        <div className= "social-link">

          {/*Github*/}
            <a href="https://github.com/sunjil98/cst-452" rel="noopener noreferer" target="-blank">
              <i className="fa fa-github-square" aria-hidden="true"/>
            </a>

            {/*bitbucket*/}
              <a href="https://www.loom.com/share/315a28246ad14bd2bf38950b0eeacdb7" rel="noopener noreferer" target="-blank">
                <i className="fa fa-youtube-square" aria-hidden="true"/>
              </a>
        </div>

</div>
           </Cell>
           </Grid>
           </div>

    )

  }
  else if(this.state.activeTab===1)
  {
    return (
      <div><h1>This is C#</h1></div>
    )
  }
  else if(this.state.activeTab===2)
  {
    return (
      <div><h1>This is PHP</h1></div>
    )
  }
  else
  {
    return (
      <div><h1>This is Java</h1></div>
    )
  }
}
  render()
  {
    return(
      <div className="category-tabs">
        <Tabs activeTab={this.state.activeTab} onChange={(tabId) => this.setState({activeTab: tabId})} ripple>
        <Tab>Capstone</Tab>
        <Tab>C#</Tab>
        <Tab>PHP</Tab>
        <Tab>Java</Tab>
        </Tabs>

            <Grid>
                <Cell col={12}>
                <div className="content">
                  {this.toggleCategories()}
                </div>
                </Cell>
            </Grid>

      </div>
    )
  }
}

export default Projects;
