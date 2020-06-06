<div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>Latest Products</h3>
    		</div>
    		<div class="see">
    			<p><a href="#">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
	      <div class="section group">
		  		<?php
				  //foreach($book as $b){
					  for($i =0;$i<count($book);$i++){
						
					  ?>
					  
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="<?= $book[$i]->hinhsach?>" alt="" /></a>
					 <h2><?= $book[$i]->tensach?> </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees"><?= $book[$i]->giasach?></span></p>
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
			<div class="content_bottom">
    		<div class="heading">
    		<h3>Hot Book</h3>
    		</div>
    		<div class="see">
    			<p><a href="#">See all Products</a></p>
    		</div>
    		<div class="clear"></div>
    	</div>
			<div class="section group">
			<?php
				  //foreach($book as $b){
					  for($i =0;$i<count($hot_book);$i++){
						
					  ?>
					  
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview.html"><img src="<?= $hot_book[$i]->hinhsach?>" alt="" /></a>
					 <h2><?= $hot_book[$i]->tensach?> </h2>
					<div class="price-details">
				       <div class="price-number">
							<p><span class="rupees"><?= $hot_book[$i]->giasach?></span></p>
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
    </div>
 </div>