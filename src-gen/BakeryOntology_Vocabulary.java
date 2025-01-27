import jadescript.content.onto.Ontology_Vocabulary;

@SuppressWarnings("all")
public interface BakeryOntology_Vocabulary extends Ontology_Vocabulary {
  public static final String IngredientQuantity = "IngredientQuantity";

  public static final String IngredientQuantity_name = "name";

  public static final String IngredientQuantity_quantity = "quantity";

  public static final String Good = "Good";

  public static final String Good_name = "name";

  public static final String Good_ingredients = "ingredients";

  public static final String Good_bakingTime = "bakingTime";

  public static final String Good_preparationTime = "preparationTime";

  public static final String Good_batchSize = "batchSize";

  public static final String OrderQuantity = "OrderQuantity";

  public static final String OrderQuantity_good = "good";

  public static final String OrderQuantity_type = "type";

  public static final String OrderQuantity_quantity = "quantity";

  public static final String Order = "Order";

  public static final String Order_id = "id";

  public static final String Order_good = "good";

  public static final String Order_status = "status";

  public static final String Order_type = "type";

  public static final String GoodsQuantity = "GoodsQuantity";

  public static final String GoodsQuantity_good = "good";

  public static final String GoodsQuantity_quantity = "quantity";

  public static final String PackageOfGoods = "PackageOfGoods";

  public static final String PackageOfGoods_packageId = "packageId";

  public static final String PackageOfGoods_contents = "contents";

  public static final String PackageOfGoods_status = "status";

  public static final String RequestOrder = "RequestOrder";

  public static final String RequestOrder_agentId = "agentId";

  public static final String AssignOrder = "AssignOrder";

  public static final String AssignOrder_agentId = "agentId";

  public static final String AssignOrder_order = "order";

  public static final String RequestIngredients = "RequestIngredients";

  public static final String RequestIngredients_ingredients = "ingredients";

  public static final String AskForHelpColleague = "AskForHelpColleague";

  public static final String AskForHelpColleague_agentId = "agentId";

  public static final String AskForHelpColleague_ingredients = "ingredients";

  public static final String RequestIngredientsColleague = "RequestIngredientsColleague";

  public static final String RequestIngredientsColleague_agentId = "agentId";

  public static final String RequestIngredientsColleague_ingredients = "ingredients";

  public static final String ProvideIngredients = "ProvideIngredients";

  public static final String ProvideIngredients_ingredients = "ingredients";

  public static final String IngredientAvaliable = "IngredientAvaliable";

  public static final String IngredientAvaliable_id = "id";

  public static final String IngredientAvaliable_avaliable = "avaliable";

  public static final String WorkerReady = "WorkerReady";

  public static final String WorkerReady_workerId = "workerId";

  public static final String WorkerReady_type = "type";

  public static final String AgentsReported = "AgentsReported";

  public static final String EndOfPrivateOrders = "EndOfPrivateOrders";

  public static final String EndOfOrders = "EndOfOrders";

  public static final String RequestPackingList = "RequestPackingList";

  public static final String ProvidePackingList = "ProvidePackingList";

  public static final String ProvidePackingList_packageList = "packageList";

  public static final String RejectOrAcceptOrder = "RejectOrAcceptOrder";

  public static final String RejectOrAcceptOrder_orderId = "orderId";

  public static final String RejectOrAcceptOrder_decision = "decision";

  public static final String RedoOrder = "RedoOrder";

  public static final String RedoOrder_orderId = "orderId";

  public static final String GoodToPack = "GoodToPack";

  public static final String GoodToPack_good = "good";

  public static final String SubmitPackage = "SubmitPackage";

  public static final String SubmitPackage_packageOfGoods = "packageOfGoods";

  public static final String RejectPackage = "RejectPackage";

  public static final String RejectPackage_packageId = "packageId";

  public static final String RejectPackage_reason = "reason";

  public static final String RepackedPackage = "RepackedPackage";

  public static final String RepackedPackage_packageId = "packageId";

  public static final String OrderStatus = "OrderStatus";

  public static final String OrderStatus_orderId = "orderId";

  public static final String OrderStatus_status = "status";

  public static final String PackageStatus = "PackageStatus";

  public static final String PackageStatus_package_ = "package_";

  public static final String PackageStatus_status = "status";

  public static final String OrderRedoRequired = "OrderRedoRequired";

  public static final String PackageReady = "PackageReady";

  public static final String PackageRejected = "PackageRejected";
}
