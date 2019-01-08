# odbhw

## Syntax for use

[command] [repository] [params]

[command] = get, add, put, delete

[command (only for pet)] = dogs, snakes

[repository] = owner, pet

## Repositories

### Commands of pet

* add pet dog <name> <times he fetched stick> <owner id> - adds new dog in repository
* add pet snake <name> < 0 | _ > <owner id>- adds new snake in repository (< 0 | _ > - if 0, then skin is not shedding, else shedding, _ is wild card)
* get pet - gets pets from repository
* get pet id <id> - gets pet with given id from repository
* get pet name <name> - gets pet with given name from repository
* get pet dogs - displays all dogs
* get pet snakes - displays all snakes
* get pet of_owner <ownerId> - gets pets of owner with given id from repository
* put pet <id> <dog | snake> <name> <times he fetched stick> <owner id> - sets new value of pet with given id 
* delete pet <id> - deletes pet with given id

### Commands of owner

* add owner <name> - adds new owner in repository
* get owner - gets owners from repository
* get owner id <id> - gets owner with given id from repository
* get owner name <name> - gets owner with given name from repository
* get owner of_pet <petId> - gets owner of pet with given id from repository
* put owner <id> <name> - sets new value of owner with given id
* delete owner <id> - deletes owner with given id
  
## Examples

add pet dog Rex 11 5

add pet snake Doodle 0 3

get owner name Tom

get owner

get pet id 1

get pet dogs

get pet snakes

put pet 1 Rex 12 5

delete pet 1

get pet of_owner 1

get owner of_pet 1
