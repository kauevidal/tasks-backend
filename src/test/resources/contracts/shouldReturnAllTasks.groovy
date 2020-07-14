package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return all tasks"
    request {
        method 'GET'
        url '/todo'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status OK()
        body([
                id         : $(regex(anInteger())),
                description: $(anyNonEmptyString()),
                dueDate    : $(anyDate())
        ])
    }
}
