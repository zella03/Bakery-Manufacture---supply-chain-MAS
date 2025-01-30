import jade.content.ContentManager;
import jade.content.lang.Codec;
import jadescript.core.behaviours.CyclicBehaviour;
import jadescript.core.exception.ExceptionThrower;
import jadescript.core.exception.JadescriptException;
import jadescript.java.AgentEnv;
import jadescript.java.SideEffectsFlag;

@SuppressWarnings("all")
public class WaitingForFinishedOrders extends CyclicBehaviour<Supervisor> {
  private Supervisor __theAgent = (Supervisor)/*Used as metadata*/null;

  private AgentEnv<Supervisor, SideEffectsFlag.AnySideEffectFlag> _agentEnv = null;

  public static WaitingForFinishedOrders __createEmpty(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    return new WaitingForFinishedOrders(_agentEnv);
  }

  private Boolean __ignoreMessageHandlers = false;

  public void doAction(final int _tickCount) {
    this.__ignoreMessageHandlers = false;
    super.doAction(_tickCount);
    __event5.run();
    __event6.run();
    __event7.run();
    __event8.run();
    if(!this.__ignoreMessageHandlers) {
    	this.__noMessageHandled();
    }
    if ( true  && !__event5.__eventFired && !__event6.__eventFired && !__event7.__eventFired && !__event8.__eventFired) __awaitForEvents();
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

  protected Integer count = null;

  public void setCount(final Integer count) {
    this.count = count;
  }

  public Integer getCount() {
    return this.count;
  }

  protected Boolean otherGroupEnded = null;

  public void setOtherGroupEnded(final Boolean otherGroupEnded) {
    this.otherGroupEnded = otherGroupEnded;
  }

  public Boolean getOtherGroupEnded() {
    return this.otherGroupEnded;
  }

  protected Boolean meNotEnded = null;

  public void setMeNotEnded(final Boolean meNotEnded) {
    this.meNotEnded = meNotEnded;
  }

  public Boolean getMeNotEnded() {
    return this.meNotEnded;
  }

  public Boolean allOrdersFinished(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    {
    	/* 
    	 * Compiled from source statement from line 174 to line 176
    	 * for order in pendingOrders do
    	 *             if status of order ≠ "finished" do
    	 *                 return false
    	 */
    	
    	for ( OrderStatus order : WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()) {
    		/* 
    		 * Compiled from source statement from line 175 to line 176
    		 * if status of order ≠ "finished" do
    		 *                 return false
    		 */
    		
    		if(!java.util.Objects.equals(order.getStatus(), "finished")) {
    			/* 
    			 * Compiled from source statement at line 176
    			 * return false
    			 */
    			
    			return false;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement from line 177 to line 180
    	 * 
    	 *         if type = "private" do
    	 * 	        for pcg in privateOrders do
    	 * 	            if status of pcg ≠ "finished" do
    	 * 	                return false
    	 */
    	
    	if(java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getType(), "private")) {
    		/* 
    		 * Compiled from source statement from line 178 to line 180
    		 * for pcg in privateOrders do
    		 * 	            if status of pcg ≠ "finished" do
    		 * 	                return false
    		 */
    		
    		for ( PackageOfGoods pcg : WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders()) {
    			/* 
    			 * Compiled from source statement from line 179 to line 180
    			 * if status of pcg ≠ "finished" do
    			 * 	                return false
    			 */
    			
    			if(!java.util.Objects.equals(pcg.getStatus(), "finished")) {
    				/* 
    				 * Compiled from source statement at line 180
    				 * return false
    				 */
    				
    				return false;
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 181
    	 * 
    	 *         return true
    	 */
    	
    	return true;
    }
  }

  public WaitingForFinishedOrders(final AgentEnv<? extends Supervisor, ? extends SideEffectsFlag.WithSideEffects> _agentEnv) {
    super(_agentEnv);
    __initializeAgentEnv();
    __initializeProperties();
    try {
    	/* 
    	 * Compiled from source statement at line 184
    	 * meNotEnded = true
    	 */
    	
    	WaitingForFinishedOrders.this.setMeNotEnded(true);
    	
    	/* 
    	 * Compiled from source statement at line 185
    	 * otherGroupEnded = false
    	 */
    	
    	WaitingForFinishedOrders.this.setOtherGroupEnded(false);
    	
    	/* 
    	 * Compiled from source statement at line 186
    	 * count = 0
    	 */
    	
    	WaitingForFinishedOrders.this.setCount(0);
    }
    catch(jadescript.core.exception.JadescriptException __throwable) {
    	__handleJadescriptException(__throwable);
    }
    catch(java.lang.Throwable __throwable) {
    	__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
    }
  }

  private class __Event5 {
    Boolean __eventFired = true;

    public void run() {
      try {
      	/* 
      	 * Compiled from source statement from line 189 to line 202
      	 * if type = "normal" and allOrdersFinished and length of orderList = 0 and meNotEnded do
      	 *             log "Ended+sending -- entered here: "+coSupplier+" __ "+coSupplier@
      	 *             send message inform GroupEndedDay to coSupplier@
      	 *             meNotEnded = false
      	 *         else if type = "normal" and allOrdersFinished and length of orderList = 0 and otherGroupEnded do
      	 *             log "hi from sending end of the dayy"
      	 *             for baker in listOfBakers do
      	 *                 send message inform EndOfDay to workerId of baker
      	 *             if length of supplierList ≠ 0 do #if means its the supplier2
      	 * 	            for supplier in supplierList do
      	 * 	                send message inform EndOfDay to supplier
      	 * 	            send message inform EndOfDay to packer
      	 *             activate FinishRaports
      	 *             deactivate this
      	 */
      	
      	if(java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getType(), "normal") && WaitingForFinishedOrders.this.allOrdersFinished(_agentEnv.getAgent().toEnv()) && java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList().size(), 0) && WaitingForFinishedOrders.this.getMeNotEnded()) {
      		/* 
      		 * Compiled from source statement at line 190
      		 * log "Ended+sending -- entered here: "+coSupplier+" __ "+coSupplier@
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on execute", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("Ended+sending -- entered here: ") + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getCoSupplier())) + java.lang.String.valueOf(" __ ")) + java.lang.String.valueOf(new jade.core.AID(java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getCoSupplier()), false))));
      		
      		/* 
      		 * Compiled from source statement at line 191
      		 * send message inform GroupEndedDay to coSupplier@
      		 */
      		
      		try {
      			jadescript.util.SendMessageUtils.validatePerformative("inform");
      			
      			java.lang.Object _contentToBeSent1586523802 = BakeryOntology.GroupEndedDay();
      			
      			jadescript.core.message.Message _synthesizedMessage1586523802 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      			
      			_synthesizedMessage1586523802.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1586523802,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      			
      			_synthesizedMessage1586523802.setLanguage(__codec.getName());;
      			
      			_synthesizedMessage1586523802.addReceiver(new jade.core.AID(java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getCoSupplier()), false));
      			
      			_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1586523802, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1586523802, "inform"));
      			
      			_agentEnv.getAgent().send(_synthesizedMessage1586523802);
      		}
      		catch(java.lang.Throwable _t) {
      			throw jadescript.core.exception.JadescriptException.wrap(_t);
      		}
      		
      		/* 
      		 * Compiled from source statement at line 192
      		 * meNotEnded = false
      		 */
      		
      		WaitingForFinishedOrders.this.setMeNotEnded(false);
      	}
      	else if(java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getType(), "normal") && WaitingForFinishedOrders.this.allOrdersFinished(_agentEnv.getAgent().toEnv()) && java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList().size(), 0) && WaitingForFinishedOrders.this.getOtherGroupEnded()) {
      		/* 
      		 * Compiled from source statement at line 194
      		 * log "hi from sending end of the dayy"
      		 */
      		
      		jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on execute", java.lang.String.valueOf("hi from sending end of the dayy"));
      		
      		/* 
      		 * Compiled from source statement from line 195 to line 196
      		 * for baker in listOfBakers do
      		 *                 send message inform EndOfDay to workerId of baker
      		 */
      		
      		for ( WorkerReady baker : WaitingForFinishedOrders.this._agentEnv.getAgent().getListOfBakers()) {
      			/* 
      			 * Compiled from source statement at line 196
      			 * send message inform EndOfDay to workerId of baker
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent48466080 = BakeryOntology.EndOfDay();
      				
      				jadescript.core.message.Message _synthesizedMessage48466080 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage48466080.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent48466080,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage48466080.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage48466080.addReceiver(baker.getWorkerId());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage48466080, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent48466080, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage48466080);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement from line 197 to line 200
      		 * 
      		 *             if length of supplierList ≠ 0 do #if means its the supplier2
      		 * 	            for supplier in supplierList do
      		 * 	                send message inform EndOfDay to supplier
      		 * 	            send message inform EndOfDay to packer
      		 */
      		
      		if(!java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getSupplierList().size(), 0)) {
      			/* 
      			 * Compiled from source statement from line 198 to line 199
      			 * for supplier in supplierList do
      			 * 	                send message inform EndOfDay to supplier
      			 */
      			
      			for ( jade.core.AID supplier : WaitingForFinishedOrders.this._agentEnv.getAgent().getSupplierList()) {
      				/* 
      				 * Compiled from source statement at line 199
      				 * send message inform EndOfDay to supplier
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent757972415 = BakeryOntology.EndOfDay();
      					
      					jadescript.core.message.Message _synthesizedMessage757972415 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage757972415.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent757972415,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage757972415.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage757972415.addReceiver(supplier);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage757972415, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent757972415, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage757972415);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 200
      			 * 
      			 * 	            send message inform EndOfDay to packer
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1151022997 = BakeryOntology.EndOfDay();
      				
      				jadescript.core.message.Message _synthesizedMessage1151022997 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1151022997.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1151022997,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1151022997.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1151022997.addReceiver(WaitingForFinishedOrders.this._agentEnv.getAgent().getPacker());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1151022997, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1151022997, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1151022997);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 201
      		 * 
      		 *             activate FinishRaports
      		 */
      		
      		new FinishRaports(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		
      		/* 
      		 * Compiled from source statement at line 202
      		 * deactivate this
      		 */
      		
      		WaitingForFinishedOrders.this.deactivate();
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

  private WaitingForFinishedOrders.__Event5 __event5 =  new WaitingForFinishedOrders.__Event5();

  private class __Event6 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitingForFinishedOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher957796730 {
      	private final __PatternMatcher957796730 __PatternMatcher957796730_obj =  this;
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		GroupEndedDay __x;
      		
      		try {
      			if(__objx instanceof GroupEndedDay) {
      				__x = (GroupEndedDay) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return java.util.Objects.equals(__x,BakeryOntology.GroupEndedDay());
      	}
      }
      __PatternMatcher957796730 __PatternMatcher957796730_obj = new __PatternMatcher957796730();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher957796730_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	WaitingForFinishedOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 207
      			 * otherGroupEnded = true
      			 */
      			
      			WaitingForFinishedOrders.this.setOtherGroupEnded(true);
      			
      			/* 
      			 * Compiled from source statement at line 208
      			 * log "Talking to co supp-- entered here"
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf("Talking to co supp-- entered here"));
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private WaitingForFinishedOrders.__Event6 __event6 = null;

  private class __Event7 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitingForFinishedOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher352437727 {
      	public java.lang.String orderId;
      	
      	public java.lang.String orderStatus;
      	
      	private final __PatternMatcher352437727 __PatternMatcher352437727_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		java.lang.String __x;
      		
      		try {
      			if(__objx instanceof java.lang.String) {
      				__x = (java.lang.String) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		orderId = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch_structterm1(java.lang.Object __objx) {
      		java.lang.String __x;
      		
      		try {
      			if(__objx instanceof java.lang.String) {
      				__x = (java.lang.String) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		orderStatus = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		OrderStatus __x;
      		
      		try {
      			if(__objx instanceof OrderStatus) {
      				__x = (OrderStatus) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getOrderId()) && headerMatch_structterm1(__x.getStatus());
      	}
      }
      __PatternMatcher352437727 __PatternMatcher352437727_obj = new __PatternMatcher352437727();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher352437727_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	WaitingForFinishedOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 211
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<OrderStatus>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 212 to line 226
      			 * if count % 5 ≠ 0 do #each 5th should be send to redo
      			 * 	        for i in pendingOrders do
      			 * 	            if orderId of i = orderId do
      			 * 	                status of i = orderStatus
      			 * 	                break
      			 * 	        log "FINISHING - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      			 * 	        log "FINISHING - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      			 * 	        
      			 * 	        
      			 * 	        log "type: "+type+" allOrdersFinished: "+allOrdersFinished+" orderList: "+orderList+" meNotEnded: "+meNotEnded
      			 * 	        #send message request_when (RedoOrder(orderId,"No need"),OrderCorrect) to senderAgent
      			 * 	        send message request RedoOrder(orderId,"No need") to senderAgent
      			 *         else do
      			 *             #send message request_when (RedoOrder(orderId,"Order not done correctly"),OrderRedoRequired) to senderAgent
      			 *             send message request RedoOrder(orderId,"Order not done correctly") to senderAgent
      			 */
      			
      			if(!java.util.Objects.equals(WaitingForFinishedOrders.this.getCount() % 5, 0)) {
      				/* 
      				 * Compiled from source statement from line 213 to line 216
      				 * for i in pendingOrders do
      				 * 	            if orderId of i = orderId do
      				 * 	                status of i = orderStatus
      				 * 	                break
      				 */
      				
      				for ( OrderStatus i : WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()) {
      					/* 
      					 * Compiled from source statement from line 214 to line 216
      					 * if orderId of i = orderId do
      					 * 	                status of i = orderStatus
      					 * 	                break
      					 */
      					
      					if(java.util.Objects.equals(i.getOrderId(), __PatternMatcher352437727_obj.orderId)) {
      						/* 
      						 * Compiled from source statement at line 215
      						 * status of i = orderStatus
      						 */
      						
      						i.setStatus(__PatternMatcher352437727_obj.orderStatus);
      						
      						/* 
      						 * Compiled from source statement at line 216
      						 * break
      						 */
      						
      						break;
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement at line 217
      				 * 
      				 * 	        log "FINISHING - Orders to make under SUPERVISOR"+ name of agent+" list: "+orderList
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("FINISHING - Orders to make under SUPERVISOR") + java.lang.String.valueOf(WaitingForFinishedOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" list: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList())));
      				
      				/* 
      				 * Compiled from source statement at line 218
      				 * log "FINISHING - Orders PENDING under SUPERVISOR"+ name of agent+" list: "+pendingOrders
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("FINISHING - Orders PENDING under SUPERVISOR") + java.lang.String.valueOf(WaitingForFinishedOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf(" list: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders())));
      				
      				/* 
      				 * Compiled from source statement at line 221
      				 * log "type: "+type+" allOrdersFinished: "+allOrdersFinished+" orderList: "+orderList+" meNotEnded: "+meNotEnded
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("type: ") + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getType())) + java.lang.String.valueOf(" allOrdersFinished: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this.allOrdersFinished(_agentEnv.getAgent().toEnv()))) + java.lang.String.valueOf(" orderList: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList())) + java.lang.String.valueOf(" meNotEnded: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this.getMeNotEnded())));
      				
      				/* 
      				 * Compiled from source statement at line 223
      				 * send message request RedoOrder(orderId,"No need") to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent155772724 = BakeryOntology.RedoOrder(__PatternMatcher352437727_obj.orderId ,"No need");
      					
      					jadescript.core.message.Message _synthesizedMessage155772724 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage155772724.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent155772724,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage155772724.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage155772724.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage155772724, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent155772724, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage155772724);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 226
      				 * send message request RedoOrder(orderId,"Order not done correctly") to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent1854295094 = BakeryOntology.RedoOrder(__PatternMatcher352437727_obj.orderId ,"Order not done correctly");
      					
      					jadescript.core.message.Message _synthesizedMessage1854295094 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage1854295094.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1854295094,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1854295094.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1854295094.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1854295094, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1854295094, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1854295094);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 227
      			 * 
      			 *         count = count + 1
      			 */
      			
      			WaitingForFinishedOrders.this.setCount(WaitingForFinishedOrders.this.getCount() + 1);
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private WaitingForFinishedOrders.__Event7 __event7 = null;

  private class __Event8 {
    Boolean __eventFired = false;

    public void run() {
      if(WaitingForFinishedOrders.this.__ignoreMessageHandlers) {
      	this.__eventFired = false;
      	
      	return ;
      }
       class __PatternMatcher1476692525 {
      	public PackageOfGoods orderPacked;
      	
      	private final __PatternMatcher1476692525 __PatternMatcher1476692525_obj =  this;
      	
      	public boolean headerMatch_structterm0(java.lang.Object __objx) {
      		PackageOfGoods __x;
      		
      		try {
      			if(__objx instanceof PackageOfGoods) {
      				__x = (PackageOfGoods) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		orderPacked = __x;
      		
      		return true;
      	}
      	
      	public boolean headerMatch(java.lang.Object __objx) {
      		PackageStatus __x;
      		
      		try {
      			if(__objx instanceof PackageStatus) {
      				__x = (PackageStatus) __objx;
      			}
      			else {
      				return false;
      			}
      		}
      		catch(java.lang.ClassCastException ignored) {
      			return false;
      		}
      		
      		return true && headerMatch_structterm0(__x.getPcg());
      	}
      }
      __PatternMatcher1476692525 __PatternMatcher1476692525_obj = new __PatternMatcher1476692525();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1476692525_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
      	}
      	catch(java.lang.Throwable _e) {
      		_e.printStackTrace();
      		
      		return false;
      	}
      }
      }))));
      jadescript.core.message.Message __receivedMessage = null;
      if(myAgent!=null) {
      	__receivedMessage = jadescript.core.message.Message.wrap(myAgent.receive(__mt));
      }
      if(__receivedMessage != null) {
      	WaitingForFinishedOrders.this.__ignoreMessageHandlers = true;
      	
      	_agentEnv.getAgent().__cleanIgnoredFlagForMessage(__receivedMessage);
      	
      	this.__eventFired = true;
      	
      	try {
      		try {
      			/* 
      			 * Compiled from source statement at line 230
      			 * allPacked = false
      			 */
      			
      			java.lang.Boolean allPacked = false;
      			
      			/* 
      			 * Compiled from source statement from line 232 to line 235
      			 * for pcg in privateOrders do
      			 *             if packageId of pcg = packageId of orderPacked do
      			 *                 status of pcg = status of orderPacked
      			 *                 break
      			 */
      			
      			for ( PackageOfGoods pcg : WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders()) {
      				/* 
      				 * Compiled from source statement from line 233 to line 235
      				 * if packageId of pcg = packageId of orderPacked do
      				 *                 status of pcg = status of orderPacked
      				 *                 break
      				 */
      				
      				if(java.util.Objects.equals(pcg.getPackageId(), __PatternMatcher1476692525_obj.orderPacked.getPackageId())) {
      					/* 
      					 * Compiled from source statement at line 234
      					 * status of pcg = status of orderPacked
      					 */
      					
      					pcg.setStatus(__PatternMatcher1476692525_obj.orderPacked.getStatus());
      					
      					/* 
      					 * Compiled from source statement at line 235
      					 * break
      					 */
      					
      					break;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 237
      			 * 
      			 *         
      			 *         log "Ready packages: "+privateOrders
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Ready packages: ") + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders())));
      			
      			/* 
      			 * Compiled from source statement from line 239 to line 243
      			 * for pcg in privateOrders do
      			 *             if status of pcg ≠ "finished" do
      			 *                 break
      			 *             else do
      			 *                 allPacked = true
      			 */
      			
      			for ( PackageOfGoods pcg : WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders()) {
      				/* 
      				 * Compiled from source statement from line 240 to line 243
      				 * if status of pcg ≠ "finished" do
      				 *                 break
      				 *             else do
      				 *                 allPacked = true
      				 */
      				
      				if(!java.util.Objects.equals(pcg.getStatus(), "finished")) {
      					/* 
      					 * Compiled from source statement at line 241
      					 * break
      					 */
      					
      					break;
      				}
      				else {
      					/* 
      					 * Compiled from source statement at line 243
      					 * allPacked = true
      					 */
      					
      					allPacked = true;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement from line 245 to line 246
      			 * 
      			 *                 
      			 *         if allPacked do
      			 *             log "ALL packages packed"
      			 */
      			
      			if(allPacked) {
      				/* 
      				 * Compiled from source statement at line 246
      				 * log "ALL packages packed"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf("ALL packages packed"));
      			}
      		}
      		catch(jadescript.core.exception.JadescriptException __throwable) {
      			__handleJadescriptException(__throwable);
      		}
      		catch(java.lang.Throwable __throwable) {
      			__handleJadescriptException(jadescript.core.exception.JadescriptException.wrap(__throwable));
      		}
      		
      		__receivedMessage = null;
      	}
      	catch(Exception _e) {
      		_e.printStackTrace();
      	}
      }
      else {
      	this.__eventFired = false;
      }
    }
  }

  private WaitingForFinishedOrders.__Event8 __event8 = null;

  private ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__DEFAULT_THROWER;

  public void __handleJadescriptException(final JadescriptException __exc) {
    jadescript.core.exception.ExceptionThrower __thrower = jadescript.core.exception.ExceptionThrower.__getExceptionEscalator(WaitingForFinishedOrders.this);
    boolean __handled = false;
    if(!__handled) {
    	__thrower.__throwJadescriptException(__exc);
    }
  }

  private void __initializeProperties() {
    // Initializing properties and event handlers:
    {
    	WaitingForFinishedOrders.this.count = 0;
    	
    	WaitingForFinishedOrders.this.otherGroupEnded = false;
    	
    	WaitingForFinishedOrders.this.meNotEnded = false;
    	
    	__event6 = new WaitingForFinishedOrders.__Event6();
    	
    	__event7 = new WaitingForFinishedOrders.__Event7();
    	
    	__event8 = new WaitingForFinishedOrders.__Event8();
    }
  }
}
