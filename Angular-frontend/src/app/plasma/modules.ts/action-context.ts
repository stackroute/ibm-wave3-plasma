
import { from } from 'rxjs';
import { ActionStrategy } from './action-strategy';
import { ChangeColorStrategy } from './change-color-strategy';
export class ActionContext {
    private currentStrategy: ActionStrategy;
    private changeColorStrategy = new ChangeColorStrategy();


    processMessage(message: string, language: string) {
        if (message.toLowerCase() === this.changeColorStrategy.getStartSignal(language)) {
            this.setStrategy(this.changeColorStrategy);
        } else if (message.toLowerCase() === this.changeColorStrategy.getEndSignal(language)) {
          this.setStrategy(null);
        }
    }

    runAction(input: string, language: string) {
        if (this.currentStrategy) {
            this.currentStrategy.runAction(input, language);
        }
    }

    setStrategy(strategy: ActionStrategy) {
        this.currentStrategy = strategy;
    }
}
