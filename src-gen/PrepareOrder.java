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
    	 * Compiled from source statement from line 269 to line 274
    	 * for ingredientToProduce in ingredients of good do
    	 *             for item in stock do
    	 *                 if name of item = name of ingredientToProduce do
    	 *                     if quantity of item < quantity of ingredientToProduce do
    	 *                         ingredientLack = IngredientQuantity(name of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    	 *                         add ingredientLack to ingredientsNeeded_lack
    	 */
    	
    	for ( IngredientQuantity ingredientToProduce : good.getIngredients()) {
    		/* 
    		 * Compiled from source statement from line 270 to line 274
    		 * for item in stock do
    		 *                 if name of item = name of ingredientToProduce do
    		 *                     if quantity of item < quantity of ingredientToProduce do
    		 *                         ingredientLack = IngredientQuantity(name of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    		 *                         add ingredientLack to ingredientsNeeded_lack
    		 */
    		
    		for ( IngredientQuantity item : PrepareOrder.this._agentEnv.getAgent().getStock()) {
    			/* 
    			 * Compiled from source statement from line 271 to line 274
    			 * if name of item = name of ingredientToProduce do
    			 *                     if quantity of item < quantity of ingredientToProduce do
    			 *                         ingredientLack = IngredientQuantity(name of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    			 *                         add ingredientLack to ingredientsNeeded_lack
    			 */
    			
    			if(java.util.Objects.equals(item.getName(), ingredientToProduce.getName())) {
    				/* 
    				 * Compiled from source statement from line 272 to line 274
    				 * if quantity of item < quantity of ingredientToProduce do
    				 *                         ingredientLack = IngredientQuantity(name of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    				 *                         add ingredientLack to ingredientsNeeded_lack
    				 */
    				
    				if(item.getQuantity() < ingredientToProduce.getQuantity()) {
    					/* 
    					 * Compiled from source statement at line 273
    					 * ingredientLack = IngredientQuantity(name of ingredientToProduce,(quantity of ingredientToProduce-quantity of item))
    					 */
    					
    					IngredientQuantity ingredientLack = BakeryOntology.IngredientQuantity(ingredientToProduce.getName() ,(ingredientToProduce.getQuantity() - item.getQuantity()));
    					
    					/* 
    					 * Compiled from source statement at line 274
    					 * add ingredientLack to ingredientsNeeded_lack
    					 */
    					
    					PrepareOrder.this.getIngredientsNeeded_lack().add(ingredientLack);
    				}
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 276
    	 * 
    	 *                         #log "Requested missing ingredient: " + name of ingredientToProduce
    	 *         return ingredientsNeeded_lack
    	 */
    	
    	return PrepareOrder.this.getIngredientsNeeded_lack();
    }
  }

  public Boolean needRestoreStock(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 279 to line 281
    	 * for item in stock do
    	 *             if quantity of item < 2 do
    	 *                 return true
    	 */
    	
    	for ( IngredientQuantity item : PrepareOrder.this._agentEnv.getAgent().getStock()) {
    		/* 
    		 * Compiled from source statement from line 280 to line 281
    		 * if quantity of item < 2 do
    		 *                 return true
    		 */
    		
    		if(item.getQuantity() < 2) {
    			/* 
    			 * Compiled from source statement at line 281
    			 * return true
    			 */
    			
    			return true;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 282
    	 * 
    	 *         return false
    	 */
    	
    	return false;
    }
  }

  public void useOfIngredients(final AgentEnv<? extends Baker, ? extends SideEffectsFlag.WithSideEffects> _agentEnv, final Good good) {
    {
    	/* 
    	 * Compiled from source statement from line 285 to line 288
    	 * for ingredientToProduce in ingredients of good do
    	 *             for item in stock do
    	 *                 if name of item = name of ingredientToProduce do
    	 *                     quantity of item = quantity of item - quantity of ingredientToProduce
    	 */
    	
    	for ( IngredientQuantity ingredientToProduce : good.getIngredients()) {
    		/* 
    		 * Compiled from source statement from line 286 to line 288
    		 * for item in stock do
    		 *                 if name of item = name of ingredientToProduce do
    		 *                     quantity of item = quantity of item - quantity of ingredientToProduce
    		 */
    		
    		for ( IngredientQuantity item : PrepareOrder.this._agentEnv.getAgent().getStock()) {
    			/* 
    			 * Compiled from source statement from line 287 to line 288
    			 * if name of item = name of ingredientToProduce do
    			 *                     quantity of item = quantity of item - quantity of ingredientToProduce
    			 */
    			
    			if(java.util.Objects.equals(item.getName(), ingredientToProduce.getName())) {
    				/* 
    				 * Compiled from source statement at line 288
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
    	 * Compiled from source statement from line 291 to line 293
    	 * if length of ingredientsNeeded_lack ≠ 0 do
    	 * 	        for i in ingredientsNeeded_lack do
    	 * 	            remove i from ingredientsNeeded_lack
    	 */
    	
    	if(!java.util.Objects.equals(PrepareOrder.this.getIngredientsNeeded_lack().size(), 0)) {
    		/* 
    		 * Compiled from source statement from line 292 to line 293
    		 * for i in ingredientsNeeded_lack do
    		 * 	            remove i from ingredientsNeeded_lack
    		 */
    		
    		for ( IngredientQuantity i : PrepareOrder.this.getIngredientsNeeded_lack()) {
    			/* 
    			 * Compiled from source statement at line 293
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
    	 * Compiled from source statement at line 297
    	 * order of this = order
    	 */
    	
    	PrepareOrder.this.setOrder(order);
    	
    	/* 
    	 * Compiled from source statement at line 298
    	 * log "Order: "+order
    	 */
    	
    	jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on create", java.lang.String.valueOf(java.lang.String.valueOf("Order: ") + java.lang.String.valueOf(order)));
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
    	 * Compiled from source statement from line 302 to line 305
    	 * for recipeOfGood in recipeBook do
    	 *             if name of recipeOfGood = good of order do
    	 *                 goodToPrepare = recipeOfGood
    	 *                 break
    	 */
    	
    	for ( Good recipeOfGood : PrepareOrder.this._agentEnv.getAgent().getRecipeBook()) {
    		/* 
    		 * Compiled from source statement from line 303 to line 305
    		 * if name of recipeOfGood = good of order do
    		 *                 goodToPrepare = recipeOfGood
    		 *                 break
    		 */
    		
    		if(java.util.Objects.equals(recipeOfGood.getName(), PrepareOrder.this.getOrder().getGood())) {
    			/* 
    			 * Compiled from source statement at line 304
    			 * goodToPrepare = recipeOfGood
    			 */
    			
    			PrepareOrder.this.setGoodToPrepare(recipeOfGood);
    			
    			/* 
    			 * Compiled from source statement at line 305
    			 * break
    			 */
    			
    			break;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 306
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
      	 * Compiled from source statement from line 309 to line 326
      	 * if length of ingredientsNeeded_lack = 0 and status of order = "toPrepare" do
      	 *             do clearNeededIngredients
      	 *             do chnageStatus with id of order,"preparing"
      	 *             status of order = "preparing"
      	 * 	        log "Agent: "+name of agent +" preparing: " + good of order
      	 * 	        
      	 * 	        do useOfIngredients with goodToPrepare
      	 * 	        log "Currect state of stock: "+stock+" of agent "+ name of agent
      	 * 	        if needRestoreStock do
      	 * 	           log "send message to supplier"#######################################################################################
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
      		 * Compiled from source statement at line 310
      		 * do clearNeededIngredients
      		 */
      		
      		PrepareOrder.this.clearNeededIngredients(_agentEnv.getAgent().toEnv());
      		
      		/* 
      		 * Compiled from source statement at line 311
      		 * do chnageStatus with id of order,"preparing"
      		 */
      		
      		PrepareOrder.this._agentEnv.getAgent().chnageStatus(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getOrder().getId() ,"preparing");
      		
      		/* 
      		 * Compiled from source statement at line 312
      		 * status of order = "preparing"
      		 */
      		
      		PrepareOrder.this.getOrder().setStatus("preparing");
      		
      		/* 
      		 * Compiled from source statement at line 313
      		 * log "Agent: "+name of agent +" preparing: " + good of order
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Agent: ") + java.lang.String.valueOf(PrepareOrder.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" preparing: ")) + java.lang.String.valueOf(PrepareOrder.this.getOrder().getGood())));
      		
      		/* 
      		 * Compiled from source statement at line 315
      		 * do useOfIngredients with goodToPrepare
      		 */
      		
      		PrepareOrder.this.useOfIngredients(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getGoodToPrepare());
      		
      		/* 
      		 * Compiled from source statement at line 316
      		 * log "Currect state of stock: "+stock+" of agent "+ name of agent
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Currect state of stock: ") + java.lang.String.valueOf(PrepareOrder.this._agentEnv.getAgent().getStock())) + java.lang.String.valueOf(" of agent ")) + java.lang.String.valueOf(PrepareOrder.this.getJadescriptAgent().getName())));
      		
      		/* 
      		 * Compiled from source statement from line 317 to line 318
      		 * if needRestoreStock do
      		 * 	           log "send message to supplier"
      		 */
      		
      		if(PrepareOrder.this.needRestoreStock(_agentEnv.getAgent().toEnv())) {
      			/* 
      			 * Compiled from source statement at line 318
      			 * log "send message to supplier"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, PrepareOrder.this.getClass().getName(), PrepareOrder.this, "on execute", java.lang.String.valueOf("send message to supplier"));
      		}
      		
      		/* 
      		 * Compiled from source statement at line 319
      		 * #######################################################################################
      		 * 	        activate BakingOrderBehavior(order,bakingTime of goodToPrepare) after (preparationTime of goodToPrepare) as duration
      		 */
      		
      		new BakingOrderBehavior(_agentEnv.getAgent().toEnv() ,PrepareOrder.this.getOrder() ,PrepareOrder.this.getGoodToPrepare().getBakingTime()).activate_after(_agentEnv.getAgent(), ((jadescript.lang.Duration) jadescript.util.types.Converter.convert((PrepareOrder.this.getGoodToPrepare().getPreparationTime()), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION), new jadescript.util.types.JadescriptTypeReference(jadescript.util.types.JadescriptBuiltinTypeAtom.DURATION))));
      	}
      	else if(!java.util.Objects.equals(PrepareOrder.this.getIngredientsNeeded_lack().size(), 0) && java.util.Objects.equals(PrepareOrder.this.getOrder().getStatus(), "toPrepare")) {
      		/* 
      		 * Compiled from source statement from line 323 to line 326
      		 * for coworker in listOfCoworkers do
      		 * 	           #checkedLackOfIngredients = true
      		 * 	           send message request AskForHelpColleague(aid,ingredientsNeeded_lack)to coworker@
      		 * 	           activate HandleIngredientsShortage(ingredientsNeeded_lack,order)
      		 */
      		
      		for ( java.lang.String coworker : PrepareOrder.this._agentEnv.getAgent().getListOfCoworkers()) {
      			/* 
      			 * Compiled from source statement at line 325
      			 * send message request AskForHelpColleague(aid,ingredientsNeeded_lack)to coworker@
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("request");
      				
      				java.lang.Object _contentToBeSent2131158485 = BakeryOntology.AskForHelpColleague(PrepareOrder.this._agentEnv.getAgent().getAID() ,PrepareOrder.this.getIngredientsNeeded_lack());
      				
      				jadescript.core.message.Message _synthesizedMessage2131158485 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      				
      				_synthesizedMessage2131158485.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent2131158485,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage2131158485.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage2131158485.addReceiver(new jade.core.AID(java.lang.String.valueOf(coworker), false));
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage2131158485, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent2131158485, "request"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage2131158485);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      			
      			/* 
      			 * Compiled from source statement at line 326
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
