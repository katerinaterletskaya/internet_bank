package terletskayasamuseva.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import terletskayasamuseva.OperationService;


@Controller
@RequestMapping(value = "/user")
public class OperationController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    private final OperationService operationService;

    @Autowired
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }
    
    
}
