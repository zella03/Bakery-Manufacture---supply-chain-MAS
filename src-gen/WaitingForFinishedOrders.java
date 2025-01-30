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
    	 * Compiled from source statement from line 170 to line 172
    	 * for order in pendingOrders do
    	 *             if status of order ≠ "finished" do
    	 *                 return false
    	 */
    	
    	for ( OrderStatus order : WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()) {
    		/* 
    		 * Compiled from source statement from line 171 to line 172
    		 * if status of order ≠ "finished" do
    		 *                 return false
    		 */
    		
    		if(!java.util.Objects.equals(order.getStatus(), "finished")) {
    			/* 
    			 * Compiled from source statement at line 172
    			 * return false
    			 */
    			
    			return false;
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement from line 173 to line 176
    	 * 
    	 *         if type = "private" do
    	 * 	        for pcg in privateOrders do
    	 * 	            if status of pcg ≠ "finished" do
    	 * 	                return false
    	 */
    	
    	if(java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getType(), "private")) {
    		/* 
    		 * Compiled from source statement from line 174 to line 176
    		 * for pcg in privateOrders do
    		 * 	            if status of pcg ≠ "finished" do
    		 * 	                return false
    		 */
    		
    		for ( PackageOfGoods pcg : WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders()) {
    			/* 
    			 * Compiled from source statement from line 175 to line 176
    			 * if status of pcg ≠ "finished" do
    			 * 	                return false
    			 */
    			
    			if(!java.util.Objects.equals(pcg.getStatus(), "finished")) {
    				/* 
    				 * Compiled from source statement at line 176
    				 * return false
    				 */
    				
    				return false;
    			}
    		}
    	}
    	
    	/* 
    	 * Compiled from source statement at line 177
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
    	 * Compiled from source statement at line 180
    	 * meNotEnded = true
    	 */
    	
    	WaitingForFinishedOrders.this.setMeNotEnded(true);
    	
    	/* 
    	 * Compiled from source statement at line 181
    	 * otherGroupEnded = false
    	 */
    	
    	WaitingForFinishedOrders.this.setOtherGroupEnded(false);
    	
    	/* 
    	 * Compiled from source statement at line 182
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
      	 * Compiled from source statement from line 185 to line 197
      	 * if type = "normal" and allOrdersFinished and length of orderList = 0 and meNotEnded do
      	 *             send message inform GroupEndedDay to coSupplier@
      	 *             meNotEnded = false
      	 *         else if type = "normal" and allOrdersFinished and length of orderList = 0 and otherGroupEnded do
      	 *             activate FinishRaports
      	 *             
      	 *             for baker in listOfBakers do
      	 *                 send message inform EndOfDay to workerId of baker
      	 *             if length of supplierList ≠ 0 do #it means its the supplier2
      	 * 	            for supplier in supplierList do
      	 * 	                send message inform EndOfDay to supplier
      	 * 	            send message inform EndOfDay to packer
      	 *             destroy this
      	 */
      	
      	if(java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getType(), "normal") && WaitingForFinishedOrders.this.allOrdersFinished(_agentEnv.getAgent().toEnv()) && java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList().size(), 0) && WaitingForFinishedOrders.this.getMeNotEnded()) {
      		/* 
      		 * Compiled from source statement at line 186
      		 * send message inform GroupEndedDay to coSupplier@
      		 */
      		
      		try {
      			jadescript.util.SendMessageUtils.validatePerformative("inform");
      			
      			java.lang.Object _contentToBeSent1463392277 = BakeryOntology.GroupEndedDay();
      			
      			jadescript.core.message.Message _synthesizedMessage1463392277 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      			
      			_synthesizedMessage1463392277.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1463392277,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      			
      			_synthesizedMessage1463392277.setLanguage(__codec.getName());;
      			
      			_synthesizedMessage1463392277.addReceiver(new jade.core.AID(java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getCoSupplier()), false));
      			
      			_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1463392277, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1463392277, "inform"));
      			
      			_agentEnv.getAgent().send(_synthesizedMessage1463392277);
      		}
      		catch(java.lang.Throwable _t) {
      			throw jadescript.core.exception.JadescriptException.wrap(_t);
      		}
      		
      		/* 
      		 * Compiled from source statement at line 187
      		 * meNotEnded = false
      		 */
      		
      		WaitingForFinishedOrders.this.setMeNotEnded(false);
      	}
      	else if(java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getType(), "normal") && WaitingForFinishedOrders.this.allOrdersFinished(_agentEnv.getAgent().toEnv()) && java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList().size(), 0) && WaitingForFinishedOrders.this.getOtherGroupEnded()) {
      		/* 
      		 * Compiled from source statement at line 189
      		 * activate FinishRaports
      		 */
      		
      		new FinishRaports(_agentEnv.getAgent().toEnv()).activate(_agentEnv.getAgent());
      		
      		/* 
      		 * Compiled from source statement from line 191 to line 192
      		 * for baker in listOfBakers do
      		 *                 send message inform EndOfDay to workerId of baker
      		 */
      		
      		for ( WorkerReady baker : WaitingForFinishedOrders.this._agentEnv.getAgent().getListOfBakers()) {
      			/* 
      			 * Compiled from source statement at line 192
      			 * send message inform EndOfDay to workerId of baker
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent96300629 = BakeryOntology.EndOfDay();
      				
      				jadescript.core.message.Message _synthesizedMessage96300629 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage96300629.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent96300629,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage96300629.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage96300629.addReceiver(baker.getWorkerId());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage96300629, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent96300629, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage96300629);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement from line 193 to line 196
      		 * 
      		 *             if length of supplierList ≠ 0 do #it means its the supplier2
      		 * 	            for supplier in supplierList do
      		 * 	                send message inform EndOfDay to supplier
      		 * 	            send message inform EndOfDay to packer
      		 */
      		
      		if(!java.util.Objects.equals(WaitingForFinishedOrders.this._agentEnv.getAgent().getSupplierList().size(), 0)) {
      			/* 
      			 * Compiled from source statement from line 194 to line 195
      			 * for supplier in supplierList do
      			 * 	                send message inform EndOfDay to supplier
      			 */
      			
      			for ( jade.core.AID supplier : WaitingForFinishedOrders.this._agentEnv.getAgent().getSupplierList()) {
      				/* 
      				 * Compiled from source statement at line 195
      				 * send message inform EndOfDay to supplier
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent1630352649 = BakeryOntology.EndOfDay();
      					
      					jadescript.core.message.Message _synthesizedMessage1630352649 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage1630352649.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1630352649,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1630352649.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1630352649.addReceiver(supplier);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1630352649, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1630352649, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1630352649);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 196
      			 * 
      			 * 	            send message inform EndOfDay to packer
      			 */
      			
      			try {
      				jadescript.util.SendMessageUtils.validatePerformative("inform");
      				
      				java.lang.Object _contentToBeSent1733674884 = BakeryOntology.EndOfDay();
      				
      				jadescript.core.message.Message _synthesizedMessage1733674884 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      				
      				_synthesizedMessage1733674884.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1733674884,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      				
      				_synthesizedMessage1733674884.setLanguage(__codec.getName());;
      				
      				_synthesizedMessage1733674884.addReceiver(WaitingForFinishedOrders.this._agentEnv.getAgent().getPacker());
      				
      				_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1733674884, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1733674884, "inform"));
      				
      				_agentEnv.getAgent().send(_synthesizedMessage1733674884);
      			}
      			catch(java.lang.Throwable _t) {
      				throw jadescript.core.exception.JadescriptException.wrap(_t);
      			}
      		}
      		
      		/* 
      		 * Compiled from source statement at line 197
      		 * 
      		 *             destroy this
      		 */
      		
      		WaitingForFinishedOrders.this.destroy();
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
       class __PatternMatcher1063553087 {
      	private final __PatternMatcher1063553087 __PatternMatcher1063553087_obj =  this;
      	
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
      __PatternMatcher1063553087 __PatternMatcher1063553087_obj = new __PatternMatcher1063553087();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1063553087_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 200
      			 * otherGroupEnded = true
      			 */
      			
      			WaitingForFinishedOrders.this.setOtherGroupEnded(true);
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
       class __PatternMatcher1105212847 {
      	public java.lang.String orderId;
      	
      	public java.lang.String orderStatus;
      	
      	private final __PatternMatcher1105212847 __PatternMatcher1105212847_obj =  this;
      	
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
      __PatternMatcher1105212847 __PatternMatcher1105212847_obj = new __PatternMatcher1105212847();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher1105212847_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 203
      			 * senderAgent = sender of message
      			 */
      			
      			jade.core.AID senderAgent = ((jadescript.core.message.InformMessage<OrderStatus>) __receivedMessage).getSender();
      			
      			/* 
      			 * Compiled from source statement from line 204 to line 214
      			 * if count % 5 ≠ 0 do #each 5th should be send to redo
      			 * 	        for i in pendingOrders do
      			 * 	            if orderId of i = orderId do
      			 * 	                status of i = orderStatus
      			 * 	                break
      			 * 	        log "FINISHING - Orders to make under SUPERVISOR"+ name of agent+"\n list: "+orderList
      			 * 	        log "FINISHING - Orders PENDING under SUPERVISOR"+ name of agent+"\n list: "+pendingOrders
      			 * 	        
      			 * 	        send message request RedoOrder(orderId,"No need") to senderAgent
      			 *         else do
      			 *             send message request RedoOrder(orderId,"Order not done correctly") to senderAgent
      			 */
      			
      			if(!java.util.Objects.equals(WaitingForFinishedOrders.this.getCount() % 5, 0)) {
      				/* 
      				 * Compiled from source statement from line 205 to line 208
      				 * for i in pendingOrders do
      				 * 	            if orderId of i = orderId do
      				 * 	                status of i = orderStatus
      				 * 	                break
      				 */
      				
      				for ( OrderStatus i : WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders()) {
      					/* 
      					 * Compiled from source statement from line 206 to line 208
      					 * if orderId of i = orderId do
      					 * 	                status of i = orderStatus
      					 * 	                break
      					 */
      					
      					if(java.util.Objects.equals(i.getOrderId(), __PatternMatcher1105212847_obj.orderId)) {
      						/* 
      						 * Compiled from source statement at line 207
      						 * status of i = orderStatus
      						 */
      						
      						i.setStatus(__PatternMatcher1105212847_obj.orderStatus);
      						
      						/* 
      						 * Compiled from source statement at line 208
      						 * break
      						 */
      						
      						break;
      					}
      				}
      				
      				/* 
      				 * Compiled from source statement at line 209
      				 * 
      				 * 	        log "FINISHING - Orders to make under SUPERVISOR"+ name of agent+"\n list: "+orderList
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("FINISHING - Orders to make under SUPERVISOR") + java.lang.String.valueOf(WaitingForFinishedOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf("\n list: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getOrderList())));
      				
      				/* 
      				 * Compiled from source statement at line 210
      				 * log "FINISHING - Orders PENDING under SUPERVISOR"+ name of agent+"\n list: "+pendingOrders
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf(java.lang.String.valueOf("FINISHING - Orders PENDING under SUPERVISOR") + java.lang.String.valueOf(WaitingForFinishedOrders.this.getJadescriptAgent().getName())) + java.lang.String.valueOf("\n list: ")) + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getPendingOrders())));
      				
      				/* 
      				 * Compiled from source statement at line 212
      				 * send message request RedoOrder(orderId,"No need") to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent1399834165 = BakeryOntology.RedoOrder(__PatternMatcher1105212847_obj.orderId ,"No need");
      					
      					jadescript.core.message.Message _synthesizedMessage1399834165 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage1399834165.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent1399834165,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage1399834165.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage1399834165.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage1399834165, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent1399834165, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage1399834165);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			else {
      				/* 
      				 * Compiled from source statement at line 214
      				 * send message request RedoOrder(orderId,"Order not done correctly") to senderAgent
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("request");
      					
      					java.lang.Object _contentToBeSent500692746 = BakeryOntology.RedoOrder(__PatternMatcher1105212847_obj.orderId ,"Order not done correctly");
      					
      					jadescript.core.message.Message _synthesizedMessage500692746 = new jadescript.core.message.Message(jadescript.core.message.Message.REQUEST);
      					
      					_synthesizedMessage500692746.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent500692746,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage500692746.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage500692746.addReceiver(senderAgent);
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage500692746, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent500692746, "request"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage500692746);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 215
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
       class __PatternMatcher467983968 {
      	public PackageOfGoods orderPacked;
      	
      	private final __PatternMatcher467983968 __PatternMatcher467983968_obj =  this;
      	
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
      __PatternMatcher467983968 __PatternMatcher467983968_obj = new __PatternMatcher467983968();
      jade.lang.acl.MessageTemplate __mt = jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(jade.lang.acl.MessageTemplate.and(new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__ignored) -> {{
      	return true;
      }
      }))), jade.lang.acl.MessageTemplate.MatchPerformative(jadescript.core.message.Message.INFORM)), jadescript.core.nativeevent.NotNativeEventTemplate.MatchNotNative(_agentEnv.getAgent().getContentManager())), new jade.lang.acl.MessageTemplate(new jadescript.lang.acl.CustomMessageTemplate(((java.util.function.Predicate<jade.lang.acl.ACLMessage>) (__templMsg) -> {{
      	jadescript.core.message.Message __receivedMessage = jadescript.core.message.Message.wrap(__templMsg);
      	
      	try {
      		return __PatternMatcher467983968_obj.headerMatch(__receivedMessage.getContent(_agentEnv.getAgent().getContentManager()));
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
      			 * Compiled from source statement at line 218
      			 * allPacked = false
      			 */
      			
      			java.lang.Boolean allPacked = false;
      			
      			/* 
      			 * Compiled from source statement from line 220 to line 223
      			 * for pcg in privateOrders do
      			 *             if packageId of pcg = packageId of orderPacked do
      			 *                 status of pcg = status of orderPacked
      			 *                 break
      			 */
      			
      			for ( PackageOfGoods pcg : WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders()) {
      				/* 
      				 * Compiled from source statement from line 221 to line 223
      				 * if packageId of pcg = packageId of orderPacked do
      				 *                 status of pcg = status of orderPacked
      				 *                 break
      				 */
      				
      				if(java.util.Objects.equals(pcg.getPackageId(), __PatternMatcher467983968_obj.orderPacked.getPackageId())) {
      					/* 
      					 * Compiled from source statement at line 222
      					 * status of pcg = status of orderPacked
      					 */
      					
      					pcg.setStatus(__PatternMatcher467983968_obj.orderPacked.getStatus());
      					
      					/* 
      					 * Compiled from source statement at line 223
      					 * break
      					 */
      					
      					break;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement at line 225
      			 * 
      			 *         
      			 *         log "Packages to prepare with status: "+privateOrders
      			 */
      			
      			jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf(java.lang.String.valueOf("Packages to prepare with status: ") + java.lang.String.valueOf(WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders())));
      			
      			/* 
      			 * Compiled from source statement from line 227 to line 232
      			 * for pcg in privateOrders do
      			 *             if status of pcg ≠ "finished" do
      			 *                 allPacked = false
      			 *                 break
      			 *             else do
      			 *                 allPacked = true
      			 */
      			
      			for ( PackageOfGoods pcg : WaitingForFinishedOrders.this._agentEnv.getAgent().getPrivateOrders()) {
      				/* 
      				 * Compiled from source statement from line 228 to line 232
      				 * if status of pcg ≠ "finished" do
      				 *                 allPacked = false
      				 *                 break
      				 *             else do
      				 *                 allPacked = true
      				 */
      				
      				if(!java.util.Objects.equals(pcg.getStatus(), "finished")) {
      					/* 
      					 * Compiled from source statement at line 229
      					 * allPacked = false
      					 */
      					
      					allPacked = false;
      					
      					/* 
      					 * Compiled from source statement at line 230
      					 * break
      					 */
      					
      					break;
      				}
      				else {
      					/* 
      					 * Compiled from source statement at line 232
      					 * allPacked = true
      					 */
      					
      					allPacked = true;
      				}
      			}
      			
      			/* 
      			 * Compiled from source statement from line 234 to line 236
      			 * 
      			 *                 
      			 *         if allPacked do
      			 *             log "ALL packages packed"
      			 *             send message inform AllPackagesReady to packer
      			 */
      			
      			if(allPacked) {
      				/* 
      				 * Compiled from source statement at line 235
      				 * log "ALL packages packed"
      				 */
      				
      				jadescript.core.Agent.doLog(jade.util.Logger.INFO, WaitingForFinishedOrders.this.getClass().getName(), WaitingForFinishedOrders.this, "on inform", java.lang.String.valueOf("ALL packages packed"));
      				
      				/* 
      				 * Compiled from source statement at line 236
      				 * send message inform AllPackagesReady to packer
      				 */
      				
      				try {
      					jadescript.util.SendMessageUtils.validatePerformative("inform");
      					
      					java.lang.Object _contentToBeSent743439639 = BakeryOntology.AllPackagesReady();
      					
      					jadescript.core.message.Message _synthesizedMessage743439639 = new jadescript.core.message.Message(jadescript.core.message.Message.INFORM);
      					
      					_synthesizedMessage743439639.setOntology(jadescript.util.SendMessageUtils.getDeclaringOntology(_contentToBeSent743439639,BakeryOntology.getInstance(),BakeryOntology.getInstance()).getName());;
      					
      					_synthesizedMessage743439639.setLanguage(__codec.getName());;
      					
      					_synthesizedMessage743439639.addReceiver(WaitingForFinishedOrders.this._agentEnv.getAgent().getPacker());
      					
      					_agentEnv.getAgent().getContentManager().fillContent(_synthesizedMessage743439639, jadescript.content.onto.MessageContent.prepareContent((jade.content.ContentElement) _contentToBeSent743439639, "inform"));
      					
      					_agentEnv.getAgent().send(_synthesizedMessage743439639);
      				}
      				catch(java.lang.Throwable _t) {
      					throw jadescript.core.exception.JadescriptException.wrap(_t);
      				}
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
