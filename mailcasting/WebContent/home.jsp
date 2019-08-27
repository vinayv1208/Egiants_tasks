<jsp:include page="header.jsp"></jsp:include>
<div id="main">
			<div class="5grid">
				<div class="main-row">
					<div class="4u-first">
						
						<section>
							<h2>Welcome to Mailservices!</h2>
							<p>Hi! This is <strong>Mail Services</strong>, a free service by <a href="http://www.javatpoint.com/">javatpoint</a><br> for <a href="http://www.cstpoint.com/">Mailing system</a>.
							You can perform all email operation,Currently  it stores the information in database
							it's free of cost.Let's try it..
							</p>
							
						</section>
					
					</div>
					<div class="4u">
						
						<section>
							
							<ul class="small-image-list">
								
					<li>
									<div>
									<% 
									
								if(session.getAttribute("username")!=null){
								String username=(String)session.getAttribute("username");		
								out.print("<font style='color:navy'>Welcome "+username+"</font>");
								}
								else{
								request.setAttribute("Error1","Plz Do login First");
								%>
								<jsp:forward page="index.jsp"></jsp:forward>
									<%}
								%></div>
									
						</li>			
								
						<li>
						<marquee direction="up">
						<font style="color: navy;"><h5>Do any kind of operation related to <br>
								Mail Services Such as Compose mail,<br>
								Inbox,And if you have Any Query just<br>
								Contact Us ..by clicking above links ..</h5></font></marquee></li>
							</span>
										 
		
							
								
							</ul>
						</section>
					
					</div>
					<div class="4u">
					
						<section>
							<h2>How about some links?</h2>
							<div class="6u-first">
								<ul class="link-list">
									<li><a href="http://www.javatpoint.com">Java tutorial and more projects</a></li>
									<li><a href="http://www.cstpoint.com">Learn C,C++,Php,Html and much more free of cost </a></li>
								
								</ul>
							</div>
							
						</section>

					</div>
				</div>
				
			</div>
		</div>

<jsp:include page="footer.html"></jsp:include>