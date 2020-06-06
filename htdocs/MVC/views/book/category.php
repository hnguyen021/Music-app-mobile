<div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>New Products</h3>
    		</div>
    		<div class="see">
    			<p><a href="#">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
	      <div class="section group" id="lol">
				

				
		  <?php
				  //foreach($book as $b){
					  for($i =0;$i<count($books);$i++){
						
					  ?>
					  
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="<?= $books[$i]->hinhsach?>" alt="" /></a>
					 <h2><?= $books[$i]->tensach?> </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees"><?= $books[$i]->giasach?></span></p>
					    </div>
					       		<div class="add-cart">								
									<h4><a href="preview.html">Add to Cart</a></h4>
							     </div>
							 <div class="clear"></div>
					</div>
					 
				</div>
				<?php
						}
				?>
				
    </div>
	<div style="margin-left:40%">
		<button id ="btn-prev" type="button" class="btn btn-outline-success">Prev</button>
		<button type="button" class="btn btn-outline-warning">Next</button>
	</div>
 </div>