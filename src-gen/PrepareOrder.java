import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.OneShotBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;
import jadescript.util.JadescriptList;

@SuppressWarnings("all")
public class PrepareOrder extends OneShotBehaviour<Baker> {
  private Baker __theAgent = (Baker)/*Used as metadata*/null;

  private AgentEnv<Baker, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static PrepareOrder __createEmpty(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new PrepareOrder(_agentEnv, new Order());
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event9.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event9.__eventFired) __awaitForEvents();
  }

  public Boolean __hasStaleMessageHandler() {
    return false;
  }

  private void __initializeAgentEnv() {
    this._agentEnv = jadescript.java.AgentEnv.agentEnv(__theAgent());
  }

  public BakeryOntology __ontology__BakeryOntology = (BakeryOntology) BakeryOntology.getInstance();

  public void __registerOntologies(final ContentManager cm) {
    super.__registerOntologies(cm);
    cm.registerOntology(BakeryOntology.getInstance());
  }

  public Codec __codec = new jade.content.lang.leap.LEAPCodec();

  protected Order order = null;

  public void setOrder(final Order order) {
    this.order = order;
  }

  public Order getOrder() {
    return this.order;
  }

  protected Good goodToPrepare = null;

  public void setGoodToPrepare(final Good goodToPrepare) {
    this.goodToPrepare = goodToPrepare;
  }

  public Good getGoodToPrepare() {
    return this.goodToPrepare;
  }

  protected JadescriptList<IngredientQuantity> ingredientsNeeded_lack = null;

  public void setIngredientsNeeded_lack(final JadescriptList<IngredientQuantity> ingredientsNeeded_lack) {
    this.ingredientsNeeded_lack = ingredientsNeeded_lack;
  }

  public JadescriptList<IngredientQuantity> getIngredientsNeeded_lack() {
    return this.ingredientsNeeded_lack;
  }

  public JadescriptList<IngredientQuantity> canPrepareOrder(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final Good good) {
    {
    	/* 
    	 * Compiled from source statement from line 339 to line 344
    	 * for ingredientToProduce in ingredients of good do
    	 *             for item in stock do
    	 *                 if ingredientName of item = ingredientName of ingredientToProduce do
    	 *                     if quantity of item < quantity of ingredientToProduce do
    	 *                         ingredientLack = IngredientQuantity(ingredientName of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    	 *                         add ingredientLack to ingredientsNeeded_lack
    	 */
    	
    	for ( IngredientQuantity ingredientToProduce : good.getIngredients()) {
    		/* 
    		 * Compiled from source statement from line 340 to line 344
    		 * for item in stock do
    		 *                 if ingredientName of item = ingredientName of ingredientToProduce do
    		 *                     if quantity of item < quantity of ingredientToProduce do
    		 *                         ingredientLack = IngredientQuantity(ingredientName of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    		 *                         add ingredientLack to ingredientsNeeded_lack
    		 */
    		
    		for ( IngredientQuantity item : PrepareOrder.this._agentEnv.getAgent().getStock()) {
    			/* 
    			 * Compiled from source statement from line 341 to line 344
    			 * if ingredientName of item = ingredientName of ingredientToProduce do
    			 *                     if quantity of item < quantity of ingredientToProduce do
    			 *                         ingredientLack = IngredientQuantity(ingredientName of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    			 *                         add ingredientLack to ingredientsNeeded_lack
    			 */
    			
    			if(java.util.Objects.equals(item.getIngredientName(), ingredientToProduce.getIngredientName())) {
    				/* 
    				 * Compiled from source statement from line 342 to line 344
    				 * if quantity of item < quantity of ingredientToProduce do
    				 *                         ingredientLack = IngredientQuantity(ingredientName of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    				 *                         add ingredientLack to ingredientsNeeded_lack
    				 */
    				
    				if(item.getQuantity() < ingredientToProduce.getQuantity()) {
    					/* 
    					 * Compiled from source statement at line 343
    					 * ingredientLack = IngredientQuantity(ingredientName of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    					 */
    					
    					IngredientQuantity ingredientLack = BakeryOntology.IngredientQuantity(ingredientToProduce.getIngredientName() ,(ingredientToProduce.getQuantity() - item.getQuantity()));
    					
    					/* 
    					 * Compiled from source statement at line 344
    					 * add ingredientLack to ingredientsNeeded_lack
    					 */
    					
    					PrepareOrder.this.getIngredientsNeeded_lack().add(ingredientLack);
    				}
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 345
    	 * 
    	 *         return ingredientsNeeded_lack
    	 */
    	
    	return PrepareOrder.this.getIngredientsNeeded_lack();
    }
  }

  public Boolean needRestoreStock(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 348 to line 350
    	 * for item in stock do
    	 *             if quantity of item <3 do
    	 *                 return true
    	 */
    	
    	for ( IngredientQuantity item : PrepareOrder.this._agentEnv.getAgent().getStock()) {
    		/* 
    		 * Compiled from source statement from line 349 to line 350
    		 * if quantity of item <3 do
    		 *                 return true
    		 */
    		
    		if(item.getQuantity() < 3) {
    			/* 
    			 * Compiled from source statement at line 350
    			 * return true
    			 */
    			
    			return true;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 351
    	 * 
    	 *         return false
    	 */
    	
    	return false;
    }
  }

  public void useOfIngredients(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final Good good) {
    {
    	/* 
    	 * Compiled from source statement from line 354 to line 357
    	 * for ingredientToProduce in ingredients of good do
    	 *             for item in stock do
    	 *                 if ingredientName of item = ingredientName of ingredientToProduce do
    	 *                     quantity of item = quantity of item - quantity of ingredientToProduce
    	 */
    	
    	for ( IngredientQuantity ingredientToProduce : good.getIngredients()) {
    		/* 
    		 * Compiled from source statement from line 355 to line 357
    		 * for item in stock do
    		 *                 if ingredientName of item = ingredientName of ingredientToProduce do
    		 *                     quantity of item = quantity of item - quantity of ingredientToProduce
    		 */
    		
    		for ( IngredientQuantity item : PrepareOrder.this._agentEnv.getAgent().getStock()) {
    			/* 
    			 * Compiled from source statement from line 356 to line 357
    			 * if ingredientName of item = ingredientName of ingredientToProduce do
    			 *                     quantity of item = quantity of item - quantity of ingredientToProduce
    			 */
    			
    			if(java.util.Objects.equals(item.getIngredientName(), ingredientToProduce.getIngredientName())) {
    				/* 
    				 * Compiled from source statement at line 357
    				 * quantity of item = quantity of item - quantity of ingredientToProduce
    				 */
    				
    				item.setQuantity(item.getQuantity() - ingredientToProduce.getQuantity());
    			}
    		}
    	}
    }
  }

  public void clearNeededIngredients(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 360 to line 362
    	 * if length of ingredientsNeeded_lack ≠ 0 do
    	 * 	        for i in ingredientsNeeded_lack do
    	 * 	            remove i from ingredientsNeeded_lack
    	 */
    	
    	if(!java.util.Objects.equals(PrepareOrder.this.getIngredientsNeeded_lack().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 361 to line 362
    		 * for i in ingredientsNeeded_lack do
    		 * 	            remove i from ingredientsNeeded_lack
    		 */
    		
    		for ( IngredientQuantity i : PrepareOrder.this.getIngredientsNeeded_lack()) {
    			/* 
    			 * Compiled from source statement at line 362
    			 * remove i from ingredientsNeeded_lack
    			 */
    			
    			PrepareOrder.this.getIngredientsNeeded_lack().remove(i);
    		}
    	}
    }
  }

  public PrepareOrder(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final Order order) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 366
    	 * order of this = order
    	 */
    	
    	PrepareOrder.this.setOrder(order);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  /**
   * PrepareOrder doOnActivate
   */
  public void doOnActivate() {
    super.doOnActivate();
    try {
    	/* 
    	 * Compiled from source statement from line 369 to line 372
    	 * for recipeOfGood in recipeBook do
    	 *             if name of recipeOfGood = good of order do
    	 *                 goodToPrepare = recipeOfGood
    	 *                 break
    	 */
    	
    	for ( Good recipeOfGood : PrepareOrder.this._agentEnv.getAgent().getRecipeBook()) {
    		/* 
    		 * Compiled from source statement from line 370 to line 372
    		 * if name of recipeOfGood = good of order do
    		 *                 goodToPrepare = recipeOfGood
    		 *                 break
    		 */
    		
    		if(java.util.Objects.equals(recipeOfGood.getName(), PrepareOrder.this.getOrder().getGood())) {
    			/* 
    			 * Compiled from source statement at line 371
    			 * goodToPrepare = recipeOfGood
    			 */
    			
    			PrepareOrder.this.setGoodToPrepare(recipeOfGood);
    			
    			/* 
    			 * Compiled from source statement at line 372
    			 * break
    			 */
    			
    			break;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 373
    	 * 
    	 *         ingredientsNeeded_lack = canPrepareOrder(goodToPrepare)
    	 */
    	
    	PrepareOrder.this.setIngredientsNeeded_lack(PrepareOrder.this.canPrepareOrder(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getGoodToPrepare()));
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event9 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 376 to line 397
      	 * if length of ingredientsNeeded_lack = 0 and status of order = "toPrepare" do
      	 *             #ingredientsNeeded_lack = [] of IngredientQuantity
      	 *             do chnageStatus with id of order,"preparing"
      	 *             status of order = "preparing"
      	 * 	        log "Agent: "+name of agent +" preparing: " + good of order
      	 * 	        
      	 * 	        do useOfIngredients with goodToPrepare
      	 * 	        log "Current state of stock: "+stock+" of agent "+ name of agent
      	 * 	        if needRestoreStock do
      	 * 	           log "send message to supplier"#######################################################################################
      	 * 	           for supplier in listOfSuppliers do
      	 * 	               activate DelayedRestockQuestion(supplier,order,false) after "PT2S" as duration
      	 * 	               #log "BAKER need RESTOCK. ask "+supplier+" having stock: "+stock
      	 * 	               #send message request NeedRestock(aid, stock) to supplier@
      	 * 	        activate BakingOrderBehavior(order,bakingTime of goodToPrepare) after (preparationTime of goodToPrepare) as duration
      	 * 	    else if length of ingredientsNeeded_lack != 0 and status of order = "toPrepare" do
      	 * 	       #log "Not enough ingredients in stock"
      	 * 	       #send message to supplier with ingredientsNeeded information#################################################################
      	 * 	       for coworker in listOfCoworkers do
      	 * 	           #checkedLackOfIngredients = true
      	 * 	           send message request AskForHelpColleague(aid,ingredientsNeeded_lack)to coworker@
      	 * 	           activate HandleIngredientsShortage(ingredientsNeeded_lack,order)
      	 */
      	
      	if(java.util.Objects.equals(PrepareOrder.this.getIngredientsNeeded_lack().size(), 0) && java.util.Objects.equals(PrepareOrder.this.getOrder().getStatus(), "toPrepare")) {
      		/* 
      		 * Compiled from source statement at line 378
      		 * do chnageStatus with id of order,"preparing"
      		 */
      		
      		PrepareOrder.this._agentEnv.getAgent().chnageStatus(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getOrder().getId() ,"preparing");
      		
      		/* 
      		 * Compiled from source statement at line 379
      		 * status of order = "preparing"
      		 */
      		
      		PrepareOrder.this.getOrder().setStatus("preparing");
      		
      		/* 
      		 * Compiled from source statement at line 380
      		 * log "Agent: "+name of agent +" preparing: " + good of order
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(PrepareOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" preparing: ")) + java.lang.String.valueOf(PrepareOrder.this.getOrder().getGood())));
      		
      		/* 
      		 * Compiled from source statement at line 382
      		 * do useOfIngredients with goodToPrepare
      		 */
      		
      		PrepareOrder.this.useOfIngredients(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getGoodToPrepare());
      		
      		/* 
      		 * Compiled from source statement at line 383
      		 * log "Current state of stock: "+stock+" of agent "+ name of agent
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Current state of stock: ") + java.lang.String.valueOf(PrepareOrder.this._agentEnv.getAgent().getStock())) + java.lang.String.valueOf(" of agent ")) + java.lang.String.valueOf(PrepareOrder.this.getJadescriptAgent().getName())));
      		
      		/* 
      		 * Compiled from source statement from line 384 to line 387
      		 * if needRestoreStock do
      		 * 	           log "send message to supplier"#######################################################################################
      		 * 	           for supplier in listOfSuppliers do
      		 * 	               activate DelayedRestockQuestion(supplier,order,false) after "PT2S" as duration
      		 */
      		
      		if(PrepareOrder.this.needRestoreStock(_agentEnv.getAgent().toEnv())) {
      			/* 
      			 * Compiled from source statement at line 385
      			 * log "send message to supplier"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on execute", java.lang.String.valueOf("send message to supplier"));
      			
      			/* 
      			 * Compiled from source statement from line 386 to line 387
      			 * for supplier in listOfSuppliers do
      			 * 	               activate DelayedRestockQuestion(supplier,order,false) after "PT2S" as duration
      			 */
      			
      			for ( java.lang.String supplier : PrepareOrder.this._agentEnv.getAgent().getListOfSuppliers()) {
      				/* 
      				 * Compiled from source statement at line 387
      				 * activate DelayedRestockQuestion(supplier,order,false) after "PT2S" as duration
      				 */
      				
      				new DelayedRestockQuestion(_agentEnv.getAgent().toEnv() ,supplier ,PrepareOrder.this.getOrder() ,false).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert("PT2S", new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.TEXT), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 390
      		 * 
      		 * 	               #log "BAKER need RESTOCK. ask "+supplier+" having stock: "+stock
      		 * 	               #send message request NeedRestock(aid, stock) to supplier@
      		 * 	        activate BakingOrderBehavior(order,bakingTime of goodToPrepare) after (preparationTime of goodToPrepare) as duration
      		 */
      		
      		new BakingOrderBehavior(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getOrder() ,PrepareOrder.this.getGoodToPrepare().getBakingTime()).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert((PrepareOrder.this.getGoodToPrepare().getPreparationTime()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
      	}
      	else if(!java.util.Objects.equals(PrepareOrder.this.getIngredientsNeeded_lack().size(), 0) && java.util.Objects.equals(PrepareOrder.this.getOrder().getStatus(), "toPrepare")) {
      		/* 
      		 * Compiled from source statement from line 394 to line 397
      		 * for coworker in listOfCoworkers do
      		 * 	           #checkedLackOfIngredients = true
      		 * 	           send message request AskForHelpColleague(aid,ingredientsNeeded_lack)to coworker@
      		 * 	           activate HandleIngredientsShortage(ingredientsNeeded_lack,order)
      		 */
      		
      		for ( java.lang.String coworker : PrepareOrder.this._agentEnv.getAgent().getListOfCoworkers()) {
      			/* 
      			 * Compiled from source statement at line 396
      			 * send message request AskForHelpColleague(aid,ingredientsNeeded_lack)to coworker@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent1562454331 = BakeryOntology.AskForHelpColleague(PrepareOrder.this._agentEnv.getAgent().getAID() ,PrepareOrder.this.getIngredientsNeeded_lack());
      				
      				jadescript.core.message.Message _synthesizedMessage1562454331 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage1562454331.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1562454331,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1562454331.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1562454331.addReceiver(new jade.core.AID(java.lang.String.valueOf(coworker), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1562454331, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1562454331, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1562454331);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 397
      			 * activate HandleIngredientsShortage(ingredientsNeeded_lack,order)
      			 */
      			
      			new HandleIngredientsShortage(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getIngredientsNeeded_lack() ,PrepareOrder.this.getOrder()).activate(_agentEnv.getAgent());
      		}
      	}
      }
      catch(jadescript.core.exception.JadescriptException __throwable) {
      	__handleJadescriptException(__throwable);
      }
      catch(java.lang.Throwable __throwable) {
      	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      }
    }
  }

  private PrepareOrder.__Event9 __event9 =  new PrepareOrder.__Event9();

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(PrepareOrder.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	PrepareOrder.this.order = new Order();
    	
    	PrepareOrder.this.goodToPrepare = new Good();
    	
    	PrepareOrder.this.ingredientsNeeded_lack = new jadescript.util.JadescriptList<IngredientQuantity>();
    }
  }
}
